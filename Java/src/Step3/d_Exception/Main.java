package Step3.d_Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class Main {
    private String password;

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) throws PasswordException{

        if(password == null){
            throw new PasswordException("비밀번호는 null 일 수 없습니다");
        }
        else if( password.length() < 5){
            throw new PasswordException("비밀번호는 5자 이상이어야 합니다.");
        }
        else if (password.matches("[a-zA-Z]+")){
            throw new PasswordException("비밀번호는 숫자나 특수문자를 포함해야 합니다.");
        }
        //throw 구문을 이용해 PasswordException 이라는 사용자 정의 Exception 클래스를 가져온 후,
        //각각의 오류에 대해 throw new Method 를 통해 처리할 내용을 입력한다.
        this.password = password;
    }


    //throw 를 쓴다는 것은 "미룬다는 것"
    public Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(fileName); //FileNotFoundException 발생
        Class c = Class.forName(className);  //ClassNotFoundException 발생
        return c;
    }

    public static void main (String[] args){
        /** [1] Exception (예외처리) **/

        int[] arr = {1,2,3,4,5};
        try{
            for(int i=0; i<=5; i++){
                System.out.println(arr[i]);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            //배열 인덱스 초과에 대한 예외 처리
            System.out.println(e);
        }
        System.out.println("비정상 종료되지 않았습니다.");

        /** [2] 반드시 실행하는 finally 구문이 있는 Exception **/
        FileInputStream fis = null;
        try {
//            fis = new FileInputStream("a.txt");
            throw new FileNotFoundException();
            //throw 는 반드시 Exception 을 받아 catch 사용
        } catch (FileNotFoundException e) {
            System.out.println(e);

        }  finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("항상 수행 됩니다.");
        }
        System.out.println("여기도 수행됩니다.");
        /** [2.5] Try Resource 방식으로 구현하면 아래와 같음 **/
        //try 의 소괄호 안에 사용할 생성자를 선언해서 실패하면 아예 생성이 안됨.
        try ( FileInputStream fis2 = new FileInputStream("a.txt")){
//            fis.asdasd;
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("여기도 수행됩니다.");


        /** [3] AutoClosable 인터페이스를 이용한 리소스 초기화 **/
        AutoCloseObj obj = new AutoCloseObj();
        try (obj){
            throw new Exception();
        }catch(Exception e) {
            System.out.println("예외 부분 입니다");
        }

        /** [4] throws 를 통한 예외 처리 패스 **/
        //내부 클래스로 지정된 loadClass 에 대해 예외 처리 패스를 구현.
        Main test = new Main();

        try {
            test.loadClass("a.txt","abd");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e){
            System.out.println("그 외의 에러 사항들 기재");
            //Exception 은 모든 exception 의 업캐스팅이기 때문에 최 하단에 사용해야만 한다.
        }

        System.out.println("4번 Throw를 통한 예외 처리 패스 (미룬다는 것)");
        //내부 클래스에서 Throw 를 처리하기 때문에 내부 구문에서 try catch 를 사용해도 상관 없다.

        /** [5] 사용자 정의 Exception 구현 **/
        //IllegalArgumentException 클래스를 사용하면 사용자 정의 Exception 에 대한 클래스 생성 가능!
        String password = null;
        try {
            test.setPassword(password);
            System.out.println("오류 없음1");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
            //해당 클래스에서 super(message)로 받아오기 때문에 getMessage() 메서드를 통해 가져옴
        }

        password = "abcd";
        try {
            test.setPassword(password);
            System.out.println("오류 없음2");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        password = "abcde";
        try {
            test.setPassword(password);
            System.out.println("오류 없음3");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }

        password = "abcde#1";
        try {
            test.setPassword(password);
            System.out.println("오류 없음4");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}
