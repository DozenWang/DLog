package me.donsen.log;

import android.content.Context;
import android.text.TextUtils;

/**
 * Created by wangyida on 15/12/10.
 */
class Config {

    private static Context sGlobalContext;
    private static String sLogDir;

    protected static Context getAppContext() {
        return sGlobalContext;
    }

    protected static void init(Context context, String logDir) {
        sGlobalContext = context;
        sLogDir = logDir;
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
}
