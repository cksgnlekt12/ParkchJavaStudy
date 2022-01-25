package Step3.e_Logger;

public class StudentNameException extends IllegalArgumentException {
    //특히 IllegalArgumentException 을 사용하면 별도로 throw 하지 않아도 생성자 쪽에서 throw 구문 사용 가능하다.
    public StudentNameException(String message) {
        super(message);
    }
}
