package Step3.j_Example.a;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
    /** [3-6] Logger 사용시에는 getLogger 메서드를 통해 커스텀 인자를 지정한다 **/
    Logger logger = Logger.getLogger("myLogger");
    MyLoggerNotSave myLoggerNotSave = MyLoggerNotSave.getLogger();

    /** [3-7] 또한 전역에서 사용되는 클래스로써 싱글톤패턴 구현을 위해 아래와 같이 instance 를 선언한다 **/
    private static MyLogger instance = new MyLogger();

    public static MyLogger getLogger(){
        return instance;
    }

    /** [3-8] 각 로그별 기록을 위해 파일명 + 경로를 지정한다. **/
    public static final String pathLog = "\\src\\Step3\\j_Example\\a\\";
    public static final String errorLog = "log.txt";
    public static final String warningLog = "warning.txt";
    public static final String fineLog = "fine.txt";

    /** [3-9] 초기화(?) 를 위해 FileHandler 를 통해 각 파일별로 선언한다 **/
    private FileHandler logFile = null;
    private FileHandler warningFile = null;
    private FileHandler fineFile = null;

    /** [3-10] Logger에 대한 특성을 선언한다 **/
    private MyLogger(){

        try {
            logFile = new FileHandler(errorLog, true);
            warningFile = new FileHandler(warningLog, true);
            fineFile = new FileHandler(fineLog, true);
            //append 가 True 면 덮어쓰기가 아니라 그 뒤에 붙여서 입력하겠다는 뜻이다.

        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        logFile.setFormatter(new SimpleFormatter());
        warningFile.setFormatter(new SimpleFormatter());
        fineFile.setFormatter(new SimpleFormatter());
        //SimpleFormatter 에서 지정된 포매터 지정

        logFile.setLevel(Level.ALL);
        fineFile.setLevel(Level.FINE);
        warningFile.setLevel(Level.WARNING);
        //레벨에는 단계적으로 severe, warning, info, config, fine, finer, finest 가 있으며, 보통 warning 이상은 catch 구문에서 사용

        logger.addHandler(logFile);
        logger.addHandler(warningFile);
        logger.addHandler(fineFile);
        //해당 로그에 사용할 핸들러를 등록해준다
    }
    public void log(String msg){
        logger.info(msg);
    }
    public void log(String type, String msg){
        switch (type) {
            case "finest":
                logger.finest(msg);
                break;
            case "finer":
                logger.finer(msg);
                break;
            case "fine":
                logger.fine(msg);
                break;
            case "config":
                logger.config(msg);
                break;
            case "info":
                logger.info(msg);
                break;
            case "warning":
                logger.warning(msg);
                break;
            default:
                logger.severe(msg);
                break;
        }
    }
    /** [3-11] 로그파일 초기화 하는 메서드인데, try 인자로 생성자 선언하였을 때 실패시 자동으로 리소스가 초기화 된다. **/
    public void init(){
        /** [3-12] FOS, DOS 를 통해 구현하였는데, FOS 선언하는 순간 이미 파일이 초기화됨. **/
        try (FileOutputStream fos1 = new FileOutputStream(errorLog);
             FileOutputStream fos2 = new FileOutputStream(warningLog);
             FileOutputStream fos3 = new FileOutputStream(fineLog);
             DataOutputStream dos1 = new DataOutputStream(fos1);
             DataOutputStream dos2 = new DataOutputStream(fos2);
             DataOutputStream dos3 = new DataOutputStream(fos3);){

            dos1.writeUTF("초기화 완료.\n");
            dos2.writeUTF("초기화 완료.\n");
            dos3.writeUTF("초기화 완료.\n");
        } catch (FileNotFoundException e) {
            myLoggerNotSave.log("warning",e.getMessage());
        } catch (IOException e) {
            myLoggerNotSave.log("warning",e.getMessage());
        }
    }
}
