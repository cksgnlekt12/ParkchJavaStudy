package Step3.i_Thread;

class JoinTest extends Thread{
    int start, end, total;

    public JoinTest (int start , int end){
        this.start = start;
        this.end = end;
    }
    public void run(){

        int i;
        total = 0;
        for ( i = start ; i < end ; i++){
            total += i;
        }
        System.out.println(total);
    }
}

class MyThread extends Thread{
    //Runnable 과는 다르게 run 메서드가 필수는 아니다...
    public void run() {

        int i;
        for(i = 0; i<200; i++) {
            System.out.print(i + "\t");
        }
    }
}
class PriorityThread extends Thread{

    public void run(){

        int sum = 0;

        Thread t = Thread.currentThread();
        System.out.println( t + "start");

        for(int i =0; i<=1000000; i++){

            sum += i;
        }

        System.out.println( t.getPriority() + "end");
    }
}

public class Main {

    public static void main(String[] args) {
        /** [1] 쓰레드 **/
        /*
        * 쓰레드란, 메모리에 올라간 어떤 행동(프로세스) 을 수행하기 위한 최소 단위 = 프로세스는 최소 하나 이상의 쓰레드를 가지고 있음.
        * 웹서버의 경우 이미 쓰레드가 구현되어 있으며, 안드로이드 같은건 직접 만들어야 할 경우가 있다.
        * 쓰레드별로 가진 변수는 "Context", 서로 공유하는 변수는 "Shared Resource" (서로 충돌하는 지역을 Critical Section 이라 함)
        * Shared Resource 에 대해서는 순차적으로 쓰레드가 접근하여 사용할 수 있도록 하는 동기화 작업(Synchronized) 이 필요하다.
         */

//        System.out.println(Thread.currentThread() + " 시작");
//        MyThread th1 = new MyThread();
//        th1.start();
//
//        MyThread th2 = new MyThread();
//        th2.start();
//        System.out.println(Thread.currentThread() + " 종료");


        /** [2] Runnable 인터페이스를 활용한 쓰레드는 ThreadTest2 클래스 참고 **/

        /** [3] 쓰레드의 상태 **/
        /*
        * Start - Runnable  - Run
                            - Dead
                            - Not Runnable (sleep / wait / join) <> (시간 지나면 or break / nofity / other thread exit)
         */

        /** [4] 쓰레드 우선 순위 **/
        int i;
        for(i=Thread.MIN_PRIORITY; i<= Thread.MAX_PRIORITY; i++){

//            PriorityThread pt = new PriorityThread();
//            pt.setPriority(i);
//            pt.start();

        }

        /** [5] join() : 다른 쓰레드의 결과를 참고해야 할 쓰레드가 있을 때 자기 자신을 Not Runnable 로 상태 변화하는 메서드 **/
        JoinTest jt1 = new JoinTest(1,10);
        JoinTest jt2 = new JoinTest(11,20);
        jt1.start();
        jt2.start();
        try {
            jt1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            jt2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //메인 함수는... jt1, jt2 쓰레드가 끝날때까지 절대 Runnable 함수로 돌아가지 않는다.
        int lastTotal = jt1.total + jt2.total;

        System.out.println("1 : " +jt1.total);
        System.out.println("2 : " + jt2.total);
        System.out.println("total : " + lastTotal);

    }

}
