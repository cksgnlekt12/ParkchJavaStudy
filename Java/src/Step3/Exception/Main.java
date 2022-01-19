package Step3.Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class Main {
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
            fis = new FileInputStream("a.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e);
            //return;
        }finally{
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

        /** [3] AutoClosable 인터페이스를 이용한 리소스 초기화 **/
        AutoCloseObj obj = new AutoCloseObj();
        try (obj){
            throw new Exception();
        }catch(Exception e) {
            System.out.println("예외 부분 입니다");
        }

    }
}
