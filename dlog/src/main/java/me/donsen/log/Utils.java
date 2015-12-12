package me.donsen.log;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangyida on 15/12/10.
 */
class Utils {

    private static String TAG = Utils.class.getSimpleName();

    protected static void create(String path) {
        if (TextUtils.isEmpty(path)) {
            throw new RuntimeException("create path is null");
        }
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static void append(String path, String content) {
        if(TextUtils.isEmpty(path)) {
            throw new IllegalArgumentException("append path is null!!!");
        }
        File file = new File(path);
        if(!file.exists()) {
            create(path);
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path, true));
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.flush();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean deleteChildren(File folder) {
        if (folder == null || !folder.exists() || !folder.isDirectory()) {
            return true;
        }

        File[] children = folder.listFiles();
        if (children == null) {
            return true;
        }

        boolean success = true;
        for (File child : children) {
            success = deletes(child) && success;
        }

        return success;
    }

    protected static boolean deletes(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            deleteChildren(file);
        }

        return file.delete();
    }

    protected static String getLogPath(String dir) {
        if(TextUtils.isEmpty(dir)) {
            throw new IllegalArgumentException("log dir is null");
        }
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String name = String.format("%1s.txt", dateFormatter.format(new Date()));
        return dir + name;
    }

    protected static String getCrashLogPath(String dir) {
        if(TextUtils.isEmpty(dir)) {
            throw new IllegalArgumentException("log dir is null");
        }
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String name = String.format("%1s_fc.txt", dateFormatter.format(new Date()));
        return dir + name;
    }

    protected static String getCurrentProcessName() {
        final int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) Config.getAppContext().getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return "";
    }


}
