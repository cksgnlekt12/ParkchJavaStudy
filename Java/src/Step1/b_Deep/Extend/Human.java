package Step1.b_Deep.Extend;

public class Human extends Animal {
    /*Override 어노테이션은 써도, 안써도 상관없으며, 클래스 구조상 컴파일 하는 데에 도움이 됨 */
    /*기존의 메서드의 메모리 영역과는 다른 새로운 메모리 영역을 사용 */
    @Override
    public void eat() {
        System.out.print("도구를 사용하여 ");
        super.eat(); //super는 상위 클래스를 의미
    }
}
