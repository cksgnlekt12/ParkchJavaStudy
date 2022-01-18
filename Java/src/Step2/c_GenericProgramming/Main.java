
package Step2.c_GenericProgramming;

public class Main {
    public static <T, V> Double makeRectangle (Point <T, V> p1, Point <T,V> p2 ){
        Double left = ((Number)p1.getX()).doubleValue();
        Double right = ((Number)p2.getX()).doubleValue();
        Double up = ((Number)p2.getY()).doubleValue();
        Double down = ((Number)p1.getY()).doubleValue();

        return (right - left) * (up - down);
    }

    public static void main(String[] args){
        /** [1] Generic 프로그래밍 기본 **/
        /* 일반적으로 extends 없이 Generic으로 정의된 클래스는 그 때 그 때마다 타입을 지정하여 생성자로 생성 가능! */
        Point<String, String> point3 = new Point<String, String>(); //즉 왼쪽 소스처럼 extends없이 전부 등록 가능

        Double rtn;
        Point<Integer, Double> point = new Point<Integer, Double>();
        Point<Integer, Double> point2 = new Point<Integer, Double>();

        point.x = 0;
        point.y =  0.0;
        point2.x = 10;
        point2.y = 10.0;

        rtn = makeRectangle(point, point2);

        System.out.println(rtn);

        /** [2] extends가 사용된 Generic 프로그래밍 **/
        /* 클래스부터 extends가 사용되면 해당 클래스에 대한 정보가 있어야만 사용이 가능하다 */
        ThreeDPrinter3 myPrinter = new ThreeDPrinter3();
        ThreeDPrinter<Powder> myPrinter2 = new ThreeDPrinter();
        ThreeDPrinter<Plastic> myPrinter3 = new ThreeDPrinter();

        myPrinter.setMaterial(new Powder());
        myPrinter2.setMaterial(new Powder());
        myPrinter3.setMaterial(new Plastic());

        Powder P = (Powder)myPrinter.getMaterial();
        //위와 같이 기존에는 Object에 대해 형변환을 통해 가져와야 했었다...
        Powder P2 = myPrinter2.getMaterial();
        Plastic P3 = myPrinter3.getMaterial();
        //그러나 위에서 제네릭 프로그래밍을 통해 선언된 오브젝트는 형변환 필요 없이 가져올 수 있다
        //Generic 프로그래밍은 컴파일 에러를 최소화 함과 동시에 중복의 제거 및 타입의 안정성을 가져올 수 있다

        System.out.println(P);
        System.out.println(P2);
        System.out.println(P3);

    }
}
