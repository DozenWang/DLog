package me.dlog.sample;

import android.app.Application;

import me.donsen.log.DLog;

/**
 * Created by wangyida on 15/12/12.
 */
public class MainApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DLog.init(this, Constants.LOG_DIR, Constants.DEBUG_LOG_EXPIRED_DAYS);
    }
}
