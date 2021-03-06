package me.donsen.log;

import android.content.Context;
import android.text.TextUtils;

/**
 * Created by wangyida on 15/12/10.
 */
class Config {

    private static Context sGlobalContext;

    private static String sLogDir;

    /**
     * log files expired days
     */
    private static int EXPIRED_DAYS = 3;

    protected static Context getAppContext() {
        return sGlobalContext;
    }

    protected static void init(Context context, String logDir, int expiredDays) {
        sGlobalContext = context;
        sLogDir = logDir;
        EXPIRED_DAYS = expiredDays;
        CrashCatcher.getInstance().init();
    }

    protected static String getDebugLogPath() {
        if(TextUtils.isEmpty(sLogDir)) {
            throw new IllegalArgumentException("log dir has not be initialized");
        }
        return Utils.getLogPath(sLogDir);
    }

    protected static String getCrashLogPath() {
        if(TextUtils.isEmpty(sLogDir)) {
            throw new IllegalArgumentException("log dir has not be initialized");
        }
        return Utils.getCrashLogPath(sLogDir);
    }

    protected static int getExpiredDays() {
        return EXPIRED_DAYS;
    }

}
