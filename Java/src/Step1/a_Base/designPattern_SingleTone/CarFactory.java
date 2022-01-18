package Step1.a_Base.designPattern_SingleTone;

public class CarFactory {
    static CarFactory instance;
    static int carNum = 10000;

    public static CarFactory getInstance(){
        if (instance == null ){
            instance = new CarFactory();
        }
        return instance;
    }

    public static Car createCar (String carName){
        carNum++;
        return new Car(carNum, carName);
    }
}
