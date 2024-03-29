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

    private static final String USER_ATTRIBUTE_NAME = "user";

    @Pointcut("execution(public * site.minnan.apimanager.userinterface.fascade..*..*(..))")
    private void user() {
    }

    @Around("user()")
    public Object setUser(ProceedingJoinPoint joinPoint) throws Throwable {
        String header = request.getHeader(AUTH_HEADER);
        String token = header.substring(7);
        String username = jwtUtil.getUsernameFromToken(token);
        Principal principal = commonUserService.loadPrincipalByUserName(username);
        if (principal == null) {
            return ResponseEntity.invalid("非法用户");
        }
        RequestContextHolder.currentRequestAttributes().setAttribute(USER_ATTRIBUTE_NAME, principal,
                RequestAttributes.SCOPE_REQUEST);
        return joinPoint.proceed();
    }

    public static Principal getPrincipal() {
        return (Principal) RequestContextHolder.currentRequestAttributes().getAttribute(USER_ATTRIBUTE_NAME,
                RequestAttributes.SCOPE_REQUEST);
    }
}
