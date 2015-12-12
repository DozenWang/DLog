# DLog
DLog is a debug log library. It can write your debug log and crash information to sdcard.
The I/O operation is operating on worker thread, so it won't be block your UI thread.

###Use It
You should call **DLog.init()** when your Application onCreate(). 
Then you can call it anywhere when you want to write your log to sdcard.
