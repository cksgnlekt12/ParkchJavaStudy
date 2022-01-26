package Step3.g_Serialization;

import java.io.*;

//직렬화 사용에 앞서 Serializable 인터페이스를 가지는 클래스 선언
class Person implements Serializable {

    private static final long serialVersionUID = -1503252402544036183L;

    String name;
    String job;

    public Person() {}

    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String toString()
    {
        return name + "," + job;
    }
}


public class Main {
    public static void main (String[] args){
        /** [1] 직렬화 **/
        // 인스턴스의 상태를 그대로 파일로 저장하거나 네트워크로 전송하고, 다시 복원하는 방식
        // 자바에서는 "보조 스트림" 을 사용하여 직렬화 제공 (ObjectInputStream, ObjectOutputStream)
        Person personAhn = new Person("이순신", "대표이사");
        Person personKim = new Person("김유신", "상무이사");

        try(FileOutputStream fos = new FileOutputStream("serial.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(personAhn);
            oos.writeObject(personKim);

        }catch(IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream("serial.out");
            ObjectInputStream ois = new ObjectInputStream(fis)){

            Person p1 = (Person)ois.readObject();//해당 메서드는 Object 로 반환되기 때문에 Person 으로 캐스팅.
            Person p2 = (Person)ois.readObject();

            System.out.println(p1);
            System.out.println(p2);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
