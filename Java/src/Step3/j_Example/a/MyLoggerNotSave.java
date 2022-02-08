package Step3.j_Example.a;

import java.util.logging.Logger;

public class MyLoggerNotSave {
    Logger logger = Logger.getLogger("myLoggerNotSave");

    private static MyLoggerNotSave instance = new MyLoggerNotSave();

    public static MyLoggerNotSave getLogger(){
        return instance;
    }

    public void log(String msg){
        if (Main.showLog == true) {
            logger.info(msg);
        };
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
}
