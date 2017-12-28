package com.example.a10062376.broadcastdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 10062376 on 2017/12/28.
 */

public class FirstActivity extends AppCompatActivity {
    private Button btnTurnToSecond;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        btnTurnToSecond = findViewById(R.id.turnToSecond);
        btnTurnToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this,SecondActivity.class));
            }
        });
    }
}
