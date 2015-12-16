# DLog
DLog is a debug log library. It can write your debug log and crash information to sdcard.
The I/O operation is operating on worker thread, so it won't block your UI thread.

###Features
* Write your debug logs to sdcard.
* Catch crash logs.
* Delete log files when it was expired. You can configure the expired days with the **DLog.init()** method.
* Divided by process. Different processes are written to different log files.

###Usage
You should call **DLog.init()** when your Application onCreate(). 
Then you can call it everywhere when you want to write your log to sdcard.

###Sample
```
public class MainApp extends Application {

    private static final String TAG = MainApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        DLog.init(this, Constants.LOG_DIR, Constants.DEBUG_LOG_EXPIRED_DAYS);

        DLog.i(TAG, "MainApp onCreate...");
    }
}
```
