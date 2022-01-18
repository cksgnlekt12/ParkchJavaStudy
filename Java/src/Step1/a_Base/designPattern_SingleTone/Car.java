package Step1.a_Base.designPattern_SingleTone;

public class Car {
    public int carNum;
    public String carName;

    public Car (int carNum, String carName){
        this.carNum = carNum;
        this.carName = carName;
    }

    public int getCarNum() {
        return carNum;
    }

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
