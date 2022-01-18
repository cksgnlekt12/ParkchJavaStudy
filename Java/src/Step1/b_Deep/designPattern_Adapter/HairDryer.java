package Step1.b_Deep.designPattern_Adapter;

public class HairDryer implements Electronic110V{
    @Override
    public void powerOn() {
        System.out.println("헤어드라이기 ON");
    }
}
