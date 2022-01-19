package Step1.a_Base;

import Step1.a_Base.designPattern_SingleTone.Car;
import Step1.a_Base.designPattern_SingleTone.CarFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /** [1] 메인 함수로써 실제 실행되는 부분 **/
    //- Public : 접근제어자
    //- Static : 정적 클래스 선언
    //- Void : 리턴값이 없음
    //- Main : 해당 클래스의 함수명
    //- args[] : 인수 (함수 내에서 패러미터로 활용)
    public static ArrayList<String> arrayList;
    public static CarFactory staticStudy;

    public static void main(String[] args){

        /** [2] 자료형으로써 final 을 지정하게 되면 최초 선언한 값으로 고정 (수정 불가능) **/
        /* 보통 final 로 선언된 변수는 "대문자" 로 약속 */
        final long SS_NO = 19910329;
        int age;
        String rtn;

        LocalDate now = LocalDate.now(); //현재 날짜를 가져오기 위한 LocalDate 클래스 Import
        LocalDate diffNow = now;

        /** [3] 기본적으로 Java는 Zero-Based **/
        diffNow = now.minusYears        ( Long.valueOf( String.valueOf(SS_NO).substring(0,4) ));
        diffNow = diffNow.minusMonths   ( Long.valueOf( String.valueOf(SS_NO).substring(4,6) ));
        diffNow = diffNow.minusDays     ( Long.valueOf( String.valueOf(SS_NO).substring(6,8) ));
        age = Integer.valueOf(String.valueOf(diffNow).substring(0,4));

        /** [4] 삼항 연산자 : 단순한 조건문을 구현하기 위한 문법 **/
        /* ( 조건문 ? 결과1 : 결과2 ) */
        Scanner sc = new Scanner(System.in);
        age = sc.nextInt();
        rtn = ( age < 30 ? "젊은편" : "아재");
        System.out.println(age + "살이면... " + rtn);

        System.out.println("------------------------------------------------------------");

        rtn = ( add ( age , -5 )  < 30 ? "젊은편" : "아재");
        System.out.println(add ( age , -5 ) + "살이면... " + rtn); // [5] 에서 지정한 함수를 통해 새로 계산.

        System.out.println("------------------------------------------------------------");

        arrayList = new ArrayList<String>();
        addArrayList("가렌");
        addArrayList("갈리오");
        addArrayList("갱플랭크");
        showAllArrayList();
        showArrayList(1);
        removeArrayList("갈리오");
        showArrayList(1);
        System.out.println("------------------------------------------------------------");

        /** [7] Static 을 통한 싱글톤 패턴 구현 예제 **/
        /* 아래 메인 함수를 컴파일 하기 위한 싱글톤 패턴을 구현하기 */
        CarFactory factory = CarFactory.getInstance();

        Car myCar1 = factory.createCar("아반떼");
        Car myCar2 = factory.createCar("투싼");

        System.out.println(myCar1.getCarNum() + " : " + myCar1.getCarName());
        System.out.println(myCar2.getCarNum() + " : " + myCar2.getCarName());
        /* static/step01_1.png 경로의 변수 종류에 따른 메모리 주소 및 역할을 인지할 것. */
    }


    /** [5] 아래와 같이 접근제어자, 자료형, 함수명, 인수로 이루어진 구조를 "함수" 라고 부른다. **/
    /* 별도로 반환할 값이 없다면 "void" 자료형을 쓰면 된다 */
    public static int add (int num1, int num2) {
        int result;
        result = num1 + num2;
        return result;
    }

    /** [6] 배열 변수인 ArrayList 의 활용 **/
    /* 해당 클래스의 최상단에 String 만을 갖는 ArrayList를 제너릭 메서드로 지정해놓았으며, 해당 변수에 대한 메서드 작성 */
    public static void addArrayList ( String name ){
        //add 메서드를 통해 arrayList 배열 변수에 넣어 줌
        if (arrayList.add(name) ) {
            System.out.println("[SYSTEM] 추가 완료!");
        }else{
            System.out.println("[SYSTEM] 실패...");
        }
    }
    public static void removeArrayList ( String name ){
        //remove 메서드를 통해 arrayList 의 해당 인덱스를 삭제함
        if (arrayList.remove(name) ) {
            System.out.println("[SYSTEM] 삭제 완료!");
        }else{
            System.out.println("[SYSTEM] 실패...");
        }
    }
    public static void showAllArrayList ( ){
        //현재 배열 변수의 모든 Item을 불러옴
        System.out.println(arrayList);
    }
    public static void showArrayList ( int index){
        //index에 맞는 Item 을 불러옴.
        System.out.println(arrayList.get(index));
    }
}
