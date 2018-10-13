package king.tool;

import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;
import org.gradle.api.logging.LogLevel;

public class Log {
    private final static Logger logger = Logging.getLogger(Log.class);
    
    public static void d(String tag,String message){
       logger.log(LogLevel.DEBUG,"[debug] "+tag+" --- "+message);
    }

    public static void i(String tag,String message){
       logger.log(LogLevel.INFO,"[info] "+tag+" --- "+message);
    }
    
    public static void l(String tag,String message){
       logger.log(LogLevel.LIFECYCLE,"[lifecycle] "+tag+" --- "+message);
    }

    public static void w(String tag,String message){
       logger.log(LogLevel.WARN,"[warn] "+tag+" --- "+message);
    }
    
    public static void q(String tag,String message){
       logger.log(LogLevel.QUIET,"[quiet] "+tag+" --- "+message);
    }
    
    public static void e(String tag,String message){
       logger.log(LogLevel.ERROR,"[error] "+tag+" --- "+message);
    }

}
