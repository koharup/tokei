package io.picchi.tokei;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


public class messageService extends Service {
    //これがないとエラー
    public IBinder onBind(Intent intent)
    {
        return null;

    }

    public void onCreate()
    {
       Thread thread = new Thread(null, task, "sentMessageService");
        thread.start();
    }

    Runnable task = new Runnable() {

        public void run() {
            Intent messageBroadcast = new Intent();
            messageBroadcast.setAction("activityAction");
            sendBroadcast(messageBroadcast);
            stopSelf();

        }
    };

}
