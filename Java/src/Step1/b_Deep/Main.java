package Step1.b_Deep;

import Step1.b_Deep.Extend.Animal;
import Step1.b_Deep.Extend.Dog;
import Step1.b_Deep.Extend.Human;
import Step1.b_Deep.designPattern_Adapter.*;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Animal> homeAnimal;
    public static void main(String[] args){
        /** [1] 객체(클래스) 간의 상속 **/
        /* 아래의 human 객체는 Animal 을 상속받은 Human 클래스의 변수 */
        /* Human 클래스는 Animal 의 메서드를 상속받아 사용할 수 있다 */
        Human human = new Human();
        Dog dog = new Dog();
        human.walk(); // walk 메서드는 Animal 클래스 메서드를 사용
        human.eat(); // eat 메서드는 "Override" 를 통해 재정의된 메서드와 함께 "super" 클래스를 통해 Animal 의 메서드를 사용
        System.out.println("------------------------------------------------------------");

        /** [2] 상속 클래스의 다형성 **/
        /* 같은 클래스를 상속받은 클래스는 하나의 종류로써 관리될 수 있다 (ex. ArrayList) */
        homeAnimal = new ArrayList<Animal>();

        homeAnimal.add(human);
        homeAnimal.add(dog);

        System.out.println(homeAnimal); //toString() 을 변환하여 해당 클래스의 실제 클래스를 가져오도록 함.
        System.out.println("------------------------------------------------------------");

        /** [3] "어댑터 패턴" 을 통해 아래 메인 함수를 컴파일 가능하도록 소스 작성 **/
        /* 인터페이스를 클래스로 사용할 수 있으나, 생성자의 클래스는 해당 인터페이스를 상속받고 있어야 한다 */
        /* 인터페이스의 경우 틀만 정의할 수 있으며 Body 에 대한 내용은 클래스에서 작성되어야 한다. */
        Electronic110V hd = new HairDryer();
        Electronic220V ac = new Aircon();
        Electronic110V ad = new Adapter(ac);

        connect(hd);
        connect(ad);
        System.out.println("------------------------------------------------------------");
    }

    public static void connect(Electronic110V a) {
        a.powerOn();
    }
}
