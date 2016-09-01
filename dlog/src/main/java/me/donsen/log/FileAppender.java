package me.donsen.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.format.DateUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.text.ParseException;


/**
 * Created by wangyida on 15/12/10.
 */
class FileAppender {

    private static HandlerThread sLoggingThread;
    private static Handler sHandler;

    private FileAppender() {
    }

    private static Handler getWorkerHandler() {
        if(sHandler == null) {
            sLoggingThread = new HandlerThread("logging-thread");
            sLoggingThread.start();
            sHandler = new Handler(sLoggingThread.getLooper());
        }
        return sHandler;
    }

    public static void append(String path, String text) {
        LoggingRunnable mRunnable = new LoggingRunnable(path, text);
        getWorkerHandler().post(mRunnable);
    }

    private static class LoggingRunnable implements Runnable {

        String text;
        String path;

        public LoggingRunnable(String path, String text) {
            this.path = path;
            this.text = text;
        }

        @Override
        public void run() {
            File file = new File(path);
            if (!file.exists()) {
                Utils.create(path);
            }
            Utils.deleteExpiredFiles(file.getParentFile(), Config.getExpiredDays());
            Utils.append(path, text);
        }
    }

}
