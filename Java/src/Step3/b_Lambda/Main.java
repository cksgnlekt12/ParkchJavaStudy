package Step3.b_Lambda;

public class Main {
    public static void main (String[] args){
        /** [1] 자바는 함수가 병렬적으로 독자적으로 실행되기에 서로 Side Effect 발생 요지가 적다 **/
        /* 람다식 문법
        * 익명 함수
        * 매개변수와 매개변수를 이용한 실행문
        * ex) ( int x, int y ) -> { return x + y; };
         */
        //람다식으로 사용되는 인터페이스는 1개의 메서드만 가지고 있어야 한다. (이름은 달라도 상관 없음)
        Add add = (int a, int b) -> {return a - b;};
        //1차적으로 Add 라는 인터페이스를 만듬
        //그 인터페이스에 대해 람다식 구현
        System.out.println(add.minus(2,3));
    }
}
