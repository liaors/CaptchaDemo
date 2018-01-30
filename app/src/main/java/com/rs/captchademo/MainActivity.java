package com.rs.captchademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rs.captchademo.captcha.Captcha;

public class MainActivity extends AppCompatActivity {
    private Captcha captcha;
    private Button btnMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMode = (Button) findViewById(R.id.btn_mode);
        captcha = (Captcha) findViewById(R.id.captCha);
        btnMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(captcha.getMode()==Captcha.MODE_BAR){
                    captcha.setMode(Captcha.MODE_NONBAR);
                    btnMode.setText("滑动条模式");
                }else{
                    captcha.setMode(Captcha.MODE_BAR);
                    btnMode.setText("无滑动条模式");
                }
            }
        });
        captcha.setCaptchaListener(new Captcha.CaptchaListener() {
            @Override
            public void onAccess(long time) {
                Toast.makeText(MainActivity.this,"验证成功",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailed(int count) {
                Toast.makeText(MainActivity.this,"验证失败,失败次数"+count,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onMaxFailed() {
                Toast.makeText(MainActivity.this,"验证超过次数，你的帐号被封锁",Toast.LENGTH_SHORT).show();
            }

        });

    }
}
