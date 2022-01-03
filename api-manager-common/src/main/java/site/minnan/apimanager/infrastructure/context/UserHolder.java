package site.minnan.apimanager.infrastructure.context;

import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import site.minnan.apimanager.application.provider.CommonUserService;
import site.minnan.apimanager.domain.entity.Principal;
import site.minnan.apimanager.infrastructure.annotation.PreAuthorized;
import site.minnan.apimanager.infrastructure.utils.JwtUtil;
import site.minnan.apimanager.userinterface.response.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@ConditionalOnProperty(value = "jwt.authorized")
@Slf4j
public class UserHolder {

    @Value("${jwt.header}")
    private String AUTH_HEADER;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CommonUserService commonUserService;

    @Pointcut("execution(public * site.minnan.apimanager.userinterface.fascade..*..*(..))")
    private void user() {
    }

    @Around("user()")
    public Object setUser(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        PreAuthorized annotation = signature.getMethod().getAnnotation(PreAuthorized.class);
        boolean authorizedRequired = annotation == null;
        String header = request.getHeader(AUTH_HEADER);
        if (StrUtil.isBlank(header) || !header.startsWith("Bearer ")) {
            log.warn("JWT Token does not begin with bearer String");
            return authorizedRequired ? ResponseEntity.invalid("非法用户") : joinPoint.proceed();
        }
        // TODO: 2022/1/3 由网关处转发时请求头丢失 
        header = header.substring(7);
        String username = null;
        try {
            username = jwtUtil.getUsernameFromToken(header);
        } catch (IllegalArgumentException e) {
            log.info("获取token信息失败");
        } catch (ExpiredJwtException e) {
            log.info("token已过期");
        }
        if (username == null) {
            return authorizedRequired ? ResponseEntity.invalid("非法用户") : joinPoint.proceed();
        }
        Principal principal = commonUserService.loadPrincipalByUserName(username);
        if (principal != null && !jwtUtil.validateToken(header, principal)) {
            RequestContextHolder.currentRequestAttributes().setAttribute("user", principal, RequestAttributes.SCOPE_REQUEST);
            return joinPoint.proceed();
        } else {
            return ResponseEntity.invalid("非法用户");
        }
    }

    public static Principal getPrincipal() {
        return (Principal) RequestContextHolder.currentRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_REQUEST);
    }
}
