package Step1.b_Deep.Extend;

public class Animal {
    public void walk(){
        System.out.println("걷습니다");
    }
    public void eat(){
        System.out.println("먹습니다");
    }

    public String toString(){
        return String.valueOf(this.getClass().getSimpleName());
    }
}
