package Step3.d_Exception;

//사용자 정의 Exception 을 구현하기 위한 클래스
public class PasswordException extends IllegalArgumentException{

    public PasswordException(String message) {
        super(message);
    }
}
