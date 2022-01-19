package Step3.b_Lambda;

public class Main {
    public static void main (String[] args){
        /** [1] 람다식 문법 **/
        /* 자바는 함수가 병렬적으로 독자적으로 실행되기에 서로 Side Effect 발생 요지가 적다
        * 익명 함수
        * 매개변수와 매개변수를 이용한 실행문
        * ex) ( int x, int y ) -> { return x + y; };
         */
        //람다식으로 사용되는 인터페이스는 1개의 메서드만 가지고 있어야 한다. (메서드 이름은 달라도 상관 없음)
        //또한 이 인터페이스는 @FunctionalInterface 어노테이션을 정의한
        Add add = (int a, int b) -> {return a + b;};
        //1차적으로 Add 라는 인터페이스를 만듬
        //그 인터페이스에 대해 람다식 구현
        System.out.println(add.add(2,3));

        /** [2] 함수형 인터페이스와 람다식 구현 **/
        Minus minus = (x, y)-> x-y; // 람다식을 인터페이스 자료형 max 변수에 대입
        System.out.println(minus.minus(5,3));

    }
}
