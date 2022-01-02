package site.minnan.apimanager.infrastructure.annotation;

import site.minnan.apimanager.infrastructure.enumerate.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PreAuthorized {

    Role[] authority() default {};
}
