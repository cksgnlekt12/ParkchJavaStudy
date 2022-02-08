package Step3.j_Example.a;

/** [3-2] 커스텀 익셉션을 작성할 경우 IllegalArgumentException 클래스를 상속받아오며, 일반적으로 String 을 인자로 하는 생성자 메서드를 통해 super 메서드 실행 **/
public class CustomException extends IllegalArgumentException{
    public CustomException(String message) {
        super(message);
    }
}