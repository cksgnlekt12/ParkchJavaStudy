package Step3.e_Logger;

public class Main {
    public static void main (String[] args){
        /* 시스템 운영에 대한 기록
        오류가 발생 했을 때 그 오류에 대한 기록을 남겨 디버깅을 용이하게 함
        로그 파일에 기록하는 코드를 추가하여 필요한 정보가 로그로 남을 수 있도록 한다
        디버깅, 시스템 에러 추적, 성능, 문제점 향상들을 위해 사용
        어느정도까지 로그를 남길 것인가?
        너무 적은 로그 : 정확한 시스템의 상황을 파악하기 어려움
        너무 많은 로그 : 빈번한 file I/O의 오버헤드와 로그 파일의 백업 문제등... */

        MyLogger myLogger = MyLogger.getLogger(); // 싱글톤패턴이므로 getLogger 라는 인스턴스로 지정함.
        myLogger.log("LogTest");


        /**시나리오
        학생 정보 시스템에 로그를 기록하도록 한다.
        학생의 이름에 오류가 있는 경우 예외 처리를 하고 예외 상황을 로그로 남긴다.
        학생의 이름은 null 이거나 중간에 space가 3개 이상인 경우 오류가 발생한다.


                구현하기
        Logger 인스턴스를 생성한다.
                로그를 남기기 위한 FileHandler를 생성한다.
        FileHandler의 level을 지정하고
        Logger에 생성된 addHandler()메서드로 FileHandler를 추가한다.**/

        String name = null;
        try{
            Student student = new Student(name);

        }catch( StudentNameException e ){
            myLogger.warning(e.getMessage());
        }

        try{
            Student student = new Student("Edward Jon Kim Test");
        }catch ( StudentNameException e){
            myLogger.warning(e.getMessage());
        }

        Student student = new Student("James");


    }
}
