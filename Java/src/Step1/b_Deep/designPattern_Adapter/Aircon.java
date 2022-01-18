package Step1.b_Deep.designPattern_Adapter;

public class Aircon implements Electronic220V{
    @Override
    public void connect(){
        System.out.println("에어콘 연결 ");
    }
}
