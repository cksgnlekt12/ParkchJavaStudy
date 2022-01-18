package Step1.b_Deep.designPattern_Adapter;

public class Adapter implements Electronic110V{
    private Electronic220V target;
    private String con;
    public Adapter(Electronic220V a){
        a.connect();
        con = a.getClass().getSimpleName();
    }

    @Override
    public void powerOn() {
        System.out.println( con + " 어댑터 연결");
    }
}
