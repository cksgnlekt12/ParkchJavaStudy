package Step3.d_Exception;

import java.io.FileInputStream;

public class AutoCloseObj implements AutoCloseable{

    //AutoClosable 인터페이스는 close 메소드가 반드시 있어야 한다.
    @Override
    public void close() {
        System.out.println("리소스가 close() 되었습니다");

    }
}

