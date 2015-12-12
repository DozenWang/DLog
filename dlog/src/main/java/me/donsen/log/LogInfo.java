package me.donsen.log;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import java.io.File;

/**
 * Created by wangyida on 15/12/10.
 */
class LogInfo {
    String level;
    String tag;
    String text;
    String timestamp;

    static String versionName;
    static String processName;

    public LogInfo(String level, String tag, String text, String timestamp) {
        this.level = level;
        this.tag = tag;
        this.text = text;
        this.timestamp = timestamp;
        getEnvIfNeed();
    }

    private void getEnvIfNeed() {
        try {
            if (TextUtils.isEmpty(versionName) || TextUtils.isEmpty(processName)) {
                PackageInfo info = Config.getAppContext().getPackageManager().getPackageInfo( Config.getAppContext().getPackageName(),
                        PackageManager.GET_UNINSTALLED_PACKAGES);
                versionName = info.versionName;
                processName = Utils.getCurrentProcessName();
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(timestamp).append(File.separator);
        buffer.append(processName).append(File.separator);
        buffer.append(versionName).append("  ");
        buffer.append(level).append(File.separator);
        buffer.append(tag).append(" : ");
        buffer.append(text).append("\n");
        return buffer.toString();
    }
}
