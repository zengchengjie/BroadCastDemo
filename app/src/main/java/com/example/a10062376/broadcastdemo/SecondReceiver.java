package com.example.a10062376.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by 10062376 on 2017/12/28.
 */

public class SecondReceiver extends BroadcastReceiver {
    private String TAG = "broadcastTest";
    @Override
    public void onReceive(Context context, Intent intent) {
        String strBroadCast = intent.getExtras().getString("testBroadCast");
        Toast.makeText(context, "我是第二个广播接收器,收到的消息为:"+strBroadCast, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "secondReceiver: "+strBroadCast);
    }
}
