package net.gfdz.com.startservicefromeanotherapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AppService extends Service {
    public AppService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return new IAppServiceInterface.Stub() {
           @Override
           public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

           }

           @Override
           public void setData(String data) throws RemoteException {
               AppService.this.data=data;
           }
       };
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service started");
        new Thread(){
            @Override
            public void run() {
                super.run();
                running = true;
                while (running){
                    System.out.println(data);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service onDestroy");
        running=false;
    }
    private String data="默认数据";
    private boolean running=false;
}
