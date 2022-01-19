package Step3.Exception;

public class AutoCloseObj implements AutoCloseable{

    //AutoClosable 인터페이스는 close 메소드가 반드시 있어야 한다.
    @Override
    public void close() throws Exception {
        System.out.println("리소스가 close() 되었습니다");
    }
}

