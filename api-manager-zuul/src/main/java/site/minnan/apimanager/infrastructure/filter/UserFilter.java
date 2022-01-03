package site.minnan.apimanager.infrastructure.filter;

import cn.hutool.core.util.StrUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import site.minnan.apimanager.application.provider.CommonUserService;
import site.minnan.apimanager.domain.entity.Principal;
import site.minnan.apimanager.infrastructure.utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.function.Consumer;

/**
 * @author Minnan on 2022/01/03
 */
@Component
@Slf4j
public class UserFilter extends ZuulFilter {

    @Value("${jwt.header}")
    private String AUTH_HEADER;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CommonUserService commonUserService;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String uri = request.getRequestURI();
        return !uri.startsWith("/apiManager/auth/");
    }

    @Override
    public Object run() throws ZuulException {
        Consumer<RequestContext> setUnAuthorized = c -> {
            c.setSendZuulResponse(false);
            c.setResponseStatusCode(401);
        };

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String header = request.getHeader(AUTH_HEADER);
        if (StrUtil.isBlank(header) || !header.startsWith("Bearer ")) {
            log.warn("JWT Token does not begin with bearer String");
            setUnAuthorized.accept(ctx);
            return null;
        }
        String token = header.substring(7);
        String username = null;
        try {
            username = jwtUtil.getUsernameFromToken(token);
        } catch (IllegalArgumentException e) {
            log.info("获取token信息失败");
        } catch (ExpiredJwtException e) {
            log.info("token已过期");
        }
        if (username == null) {
            setUnAuthorized.accept(ctx);
            return null;
        }
        Principal principal = commonUserService.loadPrincipalByUserName(username);
        if (principal == null && jwtUtil.validateToken(token, principal)) {
            ctx.addZuulRequestHeader(AUTH_HEADER, header);
        } else {
            setUnAuthorized.accept(ctx);
        }
        return null;
    }


}
