package Step3.i_Thread;

class MyThread2 implements Runnable{
    //Thread 와는 다르게 run 이 필수 메서드!
    public void run(){

        int i;
        for(i=0; i<200; i++){

            System.out.print(i + "\t");


        }
    }
}


public class ThreadTest2 {

    public static void main(String[] args) {

        System.out.println("main start");

        MyThread2 mth = new MyThread2();
        Thread th1 = new Thread(mth);
        //Runnable 인터페이스를 받는 쓰레드의 경우 쓰레드 생성자의 매개변수로 해당 클래스를 불러오면 된다...
        th1.start();

        Thread th2 = new Thread(new MyThread2());
        th2.start();

        System.out.println("main end");
    }

}
