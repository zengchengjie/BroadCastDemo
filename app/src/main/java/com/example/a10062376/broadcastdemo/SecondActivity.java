package com.example.a10062376.broadcastdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 10062376 on 2017/12/27.
 */

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String MyBroadCast = "testBroadcast";
    private Button button,btnClose,btnTurnToThird;
    private MyBroadCastReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver();
        button = findViewById(R.id.btnBroadCast);
        btnClose = findViewById(R.id.btnCloseActivity);
        btnTurnToThird = findViewById(R.id.btnTurnToThird);
        button.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        btnTurnToThird.setOnClickListener(this);
    }

    /**
     * activity销毁时及时注销广播
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    /**
     * 动态注册广播
     */
    private void registerReceiver(){
        receiver = new MyBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        intentFilter.addAction(MyBroadCast);
        registerReceiver(receiver,intentFilter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            /**
             * 发送的广播为全局的消息，只要注册过的接收器就可以接受到消息，即可以有多个逻辑处理该消息
             */
            case R.id.btnBroadCast:
                Intent intent=new Intent(MyBroadCast);
//                intent.setAction(MyBroadCast);
                intent.putExtra("testBroadCast","此处发送一条广播");
                sendBroadcast(intent);
                break;
            case R.id.btnCloseActivity:
                SecondActivity.this.finish();
                break;
            case R.id.btnTurnToThird:
                startActivity(new Intent(this,ThirdActivity.class));
                break;
        }
    }
}
