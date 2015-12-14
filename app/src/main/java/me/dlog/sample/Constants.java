package me.dlog.sample;

import android.os.Environment;

import java.io.File;

/**
 * Created by wangyida on 15/12/12.
 */
public class Constants {

    public static final String LOG_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "DLog" + File.separator;

    public static final int DEBUG_LOG_EXPIRED_DAYS = 3;
}
