package me.donsen.log;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangyida on 15/12/10.
 */
class Formatter {

    private static SimpleDateFormat sDateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    private static LogInfo sLogInfo;

    public static String format(String level, String tag, String text) {
        getLogInfo().setLevel(level).setTag(tag).setText(text).setTimestamp(sDateFormatter.format(new Date()));
        return getLogInfo().toString();
    }

    private static LogInfo getLogInfo() {
        if(sLogInfo == null) {
            sLogInfo = new LogInfo();
        }
        return sLogInfo;
    }
}
