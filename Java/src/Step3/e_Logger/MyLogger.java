package Step3.e_Logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {

    Logger logger = Logger.getLogger("mylogger");
    //mylogger 이라는 특정 Logger 이름을 사용자 정의하여 사용하겠다는 선언
    private static MyLogger instance = new MyLogger();

    public static final String errorLog = "log.txt";
    public static final String warningLog = "warning.txt";
    public static final String fineLog = "fine.txt";

    private FileHandler logFile = null;
    private FileHandler warningFile = null;
    private FileHandler fineFile = null;

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

        logger.setLevel(Level.ALL);
        fineFile.setLevel(Level.FINE);
        warningFile.setLevel(Level.WARNING);
        //레벨에는 단계적으로 severe, warning, info, config, fine, finer, finest 가 있으며, 보통 warning 이상은 catch 구문에서 사용

        logger.addHandler(logFile);
        logger.addHandler(warningFile);
        logger.addHandler(fineFile);
    }


    public static MyLogger getLogger(){
        return instance;
    }


    public void log(String msg){

        logger.finest(msg);
        logger.finer(msg);
        logger.fine(msg);
        logger.config(msg);
        logger.info(msg);
        logger.warning(msg);
        logger.severe(msg);

    }

    public void fine(String msg){
        logger.fine(msg);
    }

    public void warning(String msg){
        logger.warning(msg);
    }
}
