package me.donsen.log;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by wangyida on 15/12/12.
 */
class CrashCatcher implements Thread.UncaughtExceptionHandler {

    protected static final String TAG = "DefaultExceptionHandler";

    private Thread.UncaughtExceptionHandler mDefaultHandler;

    private static CrashCatcher instance = new CrashCatcher();

    private CrashCatcher() {
    }

    public static CrashCatcher getInstance() {
        return instance;
    }

    protected void init() {
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(final Thread thread, final Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Log.e(TAG, "Error : ", e);
            }
            Log.e(TAG, "Error : ", ex);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return true;
        }
        Utils.append(Config.getCrashLogPath(), generateCrashLog(ex));
        return true;
    }

    private String generateCrashLog(Throwable ex) {
        Writer info = new StringWriter();
        PrintWriter printWriter = new PrintWriter(info);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        String result = info.toString();
        printWriter.close();
        return result;
    }


}
