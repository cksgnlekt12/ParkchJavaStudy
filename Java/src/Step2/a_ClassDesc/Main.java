package Step2.a_ClassDesc;

import Step2.a_ClassDesc.Object.TestClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static java.util.Objects.hash;

public class Main {
    /** [1] Object 클래스 **/
    /* 일반적으로 java.lang 패키지는 import 하지 않아도 자동으로 import 된다  ( import.java.lang.* ) */
    /* 많이 사용되는 기본 클래스들이 속한 패키지 */
    static String varString;
    static Integer varInteger;     //int 로도 사용 가능)
    static Long varLong;
    static TestClass testClass;    //기본적으로 모든 사용자정의된 클래스는 Object 클래스를 상속받는다. (즉, 자동적으로 extends Object 를 해줌)

    public static void main (String[] args){
        testClass = new TestClass();

        /** [2] toString 을 변환하게 되면 해당 클래스에 대해 반환되는 값이 다르다. **/
        System.out.println(testClass);
        System.out.println("------------------------------------------------------------");

        /** [3] == 와 .eqauls() 메서드의 차이는 == 는 메모리 주소를 비교하고, eqauls 는 변수의 내용(인스턴스 주소)을 비교! **/
        /* 즉, eqauls 메서드는 "hashCode" 메서드를 통해 비교한다 */
        varString = "박찬휘";
        String varString2 = new String("박찬휘");
        System.out.println(varString);
        System.out.println(varString2);
        if (varString == varString2){
            System.out.println("같은 주소입니다!");
        }
        if (varString.equals(varString2)){
            System.out.println("같은 값입니다!");
        }
        System.out.println("------------------------------------------------------------");

        /** [4] hashCode() 메서드는 인스턴스의 주소를 저장해준다. 이 방식은 힙 메모리에 저장되는데에 사용 **/
        /* 객체 HashCode는 객체를 식별하는 하나의 "정수" 이다. 이는 오버라이딩을 통해 재정의 가능하다. */
        System.out.println(varString.hashCode());
        System.out.println(hash(varString));
        System.out.println(varString2.hashCode());
        System.out.println(hash(varString2.hashCode()));
        /* 질문
        1. Hash 메서드와 HashCode 메서드의 차이?
            -
        2. 메모리 주소와 인스턴스의 주소의 차이?
            -
         */
        System.out.println("------------------------------------------------------------");

        /** [5] String 클래스 **/
        /* 내부적으로 가변적인 char[] 배열을 가진다. */
        /* 즉 계속해서 인스턴스를 생성하는 것이 아닌, 임시적으로 char[] 배열을 이용하여 반환하는 형태 */

        String java = new String("java");
        String android = new String("android");

        /** [6] String 클래스의 StringBuilder 에 대한 이해 **/
        StringBuilder buffer = new StringBuilder(java); //단일 쓰레드에서 자주 사용되는 StringBuilder
        //java 변수를 StringBuilder 클래스의 변수 buffer 에 삽입
        System.out.println(System.identityHashCode(buffer));
        //buffer 의 인스턴스 주소
        buffer.append("android");
        //buffer 의 뒤에 android 라는 char[] 배열의 String 을 더해줌
        System.out.println(System.identityHashCode(buffer));
        //buffer 의 인스턴스 주소 -> char[] 이 변하지 않고 배열의 가변 길이만 적용되기 때문에 인스턴스 주소는 그대로다.

        java = buffer.toString();
        //buffer는 StringBuilder 타입이니 toString() 메서드를 통해 반환
        System.out.println(java);
        System.out.println("------------------------------------------------------------");

//        /** [7] Text Block 사용 방법 (java 13 버젼 이상) **/
//        String varString3 =
//            """
//            Text Block 테스트
//            """;
//        System.out.println(varString3); //난 왜 안됨?

        /** [8] Class 클래스 **/
        /* Class 클래스는 컴파일 된 class 파일을 로드하여 객체를 동적 로드하고, 정보를 가져오는 메서드가 제공됨 */
        try {
            /** [9] 클래스 동적 로드 **/
            Class c1 = Class.forName("java.lang.String");
            System.out.println(c1.getSimpleName());
            //c1라는 클래스를 forName 메서드를 통해 String 클래스로 동적으로 로드하여 선언한다.
            Class c2 = String.class;
            System.out.println(c2.getSimpleName());
            //c2라는 클래스를 클래스 직접 선언을 통해 String 클래스로 동적으로 로드하여 선언한다.
            Class c3 = varString.getClass();
            System.out.println(c3.getSimpleName());
            //c3라는 클래스를 이미 선언된 String 클래스를 가져와서 String 클래스로 동적으로 로드하여 선언한다.
            /* 위와 같이 동적 로딩을 통해 선언하게 되면, 컴파일 시에 데이터 타입이 바인딩이 되는 것이 아니라,
                런타임 중에 바인딩이 되기 때문에 원하는 클래스로 그 때마다 선언이 가능하다. */
            System.out.println("------------------------------------------------------------");

            /** [10] Reflection 프로그래밍을 통해 해당 객체의 클래스 정보를 알 수 있다 **/
            /* 자료형이 아니고, 일반적으로 객체의 타입을 알 수 없을 때 사용 */

            Constructor<String>[] cons =  c3.getConstructors();
            /* Import 된 클래스 정보를 가져온다 */
            for(Constructor con: cons) {
                System.out.println(con);
            }

            System.out.println();

            /* 사용 가능한 메서드 정보를 가져온다 */
            Method[] methods = c3.getMethods();
            for(Method  method : methods) {
                System.out.println(method);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
