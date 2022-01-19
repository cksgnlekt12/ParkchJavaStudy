package Step3.c_Stream.Example;

public class Customer {
    public String name;
    public int age;
    public int cost;

    public Customer ( String name, int age, int cost){
        this.name = name;
        this.age = age;
        this.cost = cost;
    }
    public String toString(){
        return "이름은 " + name + "이요, 나이는 " + age + "살의 " + cost + "짜리 사람이오";
    }
}
