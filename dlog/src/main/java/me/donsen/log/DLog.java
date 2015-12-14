package me.donsen.log;

import android.content.Context;
import android.util.Log;

/**
 * Created by wangyida on 15/12/10.
 */
public class DLog {

    // 定义的log等级。越高越严重。
    enum LEVEL {
        INFO,
        DEBUG,
        WARN,
        ERROR
    }


    private static LEVEL LOG_LEVEL = LEVEL.INFO;

    /**
     * init DLog config arguements
     * @param context
     * @param logDir
     * @param expiredDays
     */
    public static void init(Context context, String logDir, int expiredDays) {
        Config.init(context, logDir, expiredDays);
    }

    public static void i(String tag, String msg) {
        Log.i(tag, msg);
        FileAppender.append(Config.getDebugLogPath(), Formatter.format(LEVEL.INFO.name(), tag, msg));
    }

    public static void d(String tag, String msg) {
        Log.d(tag, msg);
        FileAppender.append(Config.getDebugLogPath(), Formatter.format(LEVEL.DEBUG.name(), tag, msg));
    }

    public static void w(String tag, String msg) {
        Log.w(tag, msg);
        FileAppender.append(Config.getDebugLogPath(), Formatter.format(LEVEL.WARN.name(), tag, msg));
    }

    public static void e(String tag, String msg) {
        Log.e(tag, msg);
        FileAppender.append(Config.getDebugLogPath(), Formatter.format(LEVEL.ERROR.name(), tag, msg));
    }



}
