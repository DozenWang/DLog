package me.dlog.sample;

import android.app.Activity;
import android.os.Bundle;

import me.donsen.log.DLog;


/**
 * Created by wangyida on 15/12/12.
 */
public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DLog.i(TAG, " onCreate..");

    }

    @Override
    protected void onResume() {
        super.onResume();
        DLog.i(TAG, " onResume..");

    }

    @Override
    protected void onPause() {
        super.onPause();
        DLog.i(TAG, " onPause..");

    }

    @Override
    protected void onStop() {
        super.onStop();
        DLog.i(TAG, " onStop..");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DLog.i(TAG, " onDestroy..");
    }
}
