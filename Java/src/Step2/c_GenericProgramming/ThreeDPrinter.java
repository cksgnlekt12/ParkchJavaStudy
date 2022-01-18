package Step2.c_GenericProgramming;

public class ThreeDPrinter<T extends Material> {
    //T 뒤에 extends 를 통해 오브젝트 클래스를 제한할 수 있다.
    private T material;

    public void setMaterial(T material) {
        this.material = material;
    }

    public T getMaterial() {
        return material;
    }
}
