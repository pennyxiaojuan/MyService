package com.example.penny.myservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button startService;
    private Button stopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //在onCreate方法里分别获取了两个按钮的实例，并注册点击事件
        startService = (Button) findViewById(R.id.start_service);
        stopService = (Button) findViewById(R.id.stop_service);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.start_service:
                //构建一个Intent对象，并调用startService方法来启动服务
                Intent startIntent = new Intent(this,MyService.class);
                startService(startIntent);//启动服务
              break;
            case R.id.stop_service:
                //同上
            Intent stopIntent = new Intent(this,MyService.class);
                    stopService(stopIntent);//停止服务
            break;
            default:
                break;
        }
    }
}

