package Step3.a_InnerClass;

class OutClass{
    private int num = 10;
    private static int sNum = 20;

    private InClass inClass;


    public OutClass(){
        inClass = new InClass();
        //OutClass가 생성되면서 InClass의 함수를 사용할 수 있게 되었다.
    }
    /////////////////////////////////////////인스턴스 내부 클래스/////////////////////////////////////
    public class InClass{
        int iNum = 100;
        //static int sInNum = 500; //내부 클래스에서는 정적 변수를 사용할 수 없다. (왜냐하면 OutClass 가 만들어 져야 InClass가 만들어지는데, 정적 변수가 미리 생성될 수 없기 때문)

        void inTest() {
            System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴수 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + iNum + "(내부 클래스의 인스턴수 변수)");
        }
    }
    public void usingClass(){
        inClass.inTest();
    }

    ////////////////////////////////////////정적 내부 클래스/////////////////////////////////////////
    static class inStaticClass {
        int iNum = 100;
        static int sInNum = 200;

        void inTest() {
            //System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴수 변수)"); //이게 오류가 뜨는 이유는 정적 내부 클래스가 만들어질 때 외부 클래스가 없을 수 있기 떄문
            System.out.println("InClass Num = " + iNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass sNum = " + sInNum + "(내부 클래스의 인스턴수 변수)");
        }
        //정적 클래스의 경우 static 메서드를 작성할 수 있다
        static void sTest(){
            //System.out.println("InClass Num = " + iNum + "(외부 클래스의 스태틱 변수)"); //이 메서드가 만들어졌을 때 정적 내부 클래스의 iNum 변수가 없을 수 있으므로 오류
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass sNum = " + sInNum + "(내부 클래스의 인스턴수 변수)");
        }
    }
}
//지역 내부 클래스
class Outer {

    int outNum = 100;
    static int sNum = 200;

    Runnable getRunnable(int i){
        int iNum = 10;

        class MyRunnable implements Runnable{

            int localNum = 1000;

            @Override
            public void run() {
//                i = 50;
//                iNum = 100; //Runnable 의 매개변수 및 지역변수는 모두 final 로 선언되기도 하고, run() 메서드는 언제든 호출이 될 수 있음

                System.out.println(i);
                System.out.println(iNum);
                System.out.println(localNum);
                System.out.println(outNum);
                System.out.println(sNum);
            }
        }
        return new MyRunnable();

//          //지역 내부 클래스를 익명 내부 클래스로 변환환 타입
//        return new Runnable(){
//
//            int localNum = 1000;
//
//            @Override
//            public void run() {
////                i = 50;
////                iNum = 100; //Runnable 의 매개변수 및 지역변수는 모두 final 로 선언되기도 하고, run() 메서드는 언제든 호출이 될 수 있음
//
//                System.out.println(i);
//                System.out.println(iNum);
//                System.out.println(localNum);
//                System.out.println(outNum);
//                System.out.println(sNum);
//            }
//        };
    }

    Runnable runnable = new Runnable(){

        @Override
        public void run() {
            System.out.println("익명내부클래스");
        }
    };
}
public class Main {
    public static void main (String[] args){
        /** [1] 인스턴스 내부 클래스 **/
        /* 내부적으로 사용할 클래스를 선언 (private) */

        OutClass outClass = new OutClass(); //OutClass를 생성하면서 inClass까지 같이 생성되었다.
        outClass.usingClass();

        OutClass.InClass inner = outClass.new InClass(); //내부클래스를 임의로 가져오는 용.
        inner.inTest();

        /** [2] 정적 내부 클래스 **/
        /* 외부 클래스 생성과 무관하게 사용할 수 있음 */

        //내부 클래스와는 다르게 바로 외부 클래스의 체이닝을 통해 생성할 수 있다.
        OutClass.inStaticClass inStaticClass = new OutClass.inStaticClass();
        inStaticClass.inTest();

        OutClass.inStaticClass.sTest();

        /** [3] 지역 내부 클래스 **/

        Outer out = new Outer();
        //Outer 의 외부클래스를 만듬

        Runnable runnable = out.getRunnable(500);
        //runnable 변수는 Outer 클래스의 getRunnable 을 참조.
        runnable.run();
        //runnable 변수는 run 을 실행할 수 있다.

        out.runnable.run();
        //별도로 out 자체적으로 runnable 인스턴수 메서드에 대해 실행도 할 수 있다.
    }
}
