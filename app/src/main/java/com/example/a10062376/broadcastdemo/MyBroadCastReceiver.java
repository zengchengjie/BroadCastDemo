package com.example.a10062376.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.net.URISyntaxException;

/**
 * Created by 10062376 on 2017/12/27.
 */

public class MyBroadCastReceiver extends BroadcastReceiver {
    private String TAG = "broadcastTest";

    //函数返回后，该方法就结束了
    @Override
    public void onReceive(Context context, Intent intent) {
        String strBroadCast = intent.getExtras().getString("testBroadCast");
        Toast.makeText(context, strBroadCast, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onReceive: " + strBroadCast);
    }
}
