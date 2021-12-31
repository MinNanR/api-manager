package site.minnan.apimanager.infrastructure.exception;

/**
 * 登录异常
 *
 * @author Minnan on 2021/12/31
 */
public class LoginException extends RuntimeException {

    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }
}
