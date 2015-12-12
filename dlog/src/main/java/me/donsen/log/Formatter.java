package me.donsen.log;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangyida on 15/12/10.
 */
class Formatter {

    private static SimpleDateFormat sDateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    public static String format(String level, String tag, String text) {
        LogInfo info = new LogInfo(level, tag, text, sDateFormatter.format(new Date()));
        return info.toString();
    }
}
