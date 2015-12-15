# DLog
DLog is a debug log library. It can write your debug log and crash information to sdcard.
The I/O operation is operating on worker thread, so it won't be block your UI thread.

###Features
* Write your debug logs to sdcard.
* Catch crash logs.
* Delete log files when it was expired. You can config the expired days with the **DLog.init()** method.
* Divided by different process. Different processes has its own log file.

###Usage
You should call **DLog.init()** when your Application onCreate(). 
Then you can call it anywhere when you want to write your log to sdcard.
