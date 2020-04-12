package com.barazeli.blogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button in_sign,up_sign;
    private Animation btn_anim,txt_anim;
    private TextView tv_welcom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        in_sign=findViewById(R.id.in_sign);
        up_sign=findViewById(R.id.up_sign);
        tv_welcom=findViewById(R.id.tv_welcome);

        // load animation
        btn_anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.btns_sign);
        txt_anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.txt);

        // setup animations
        tv_welcom.setAnimation(txt_anim);
        in_sign.setAnimation(btn_anim);
        up_sign.setAnimation(btn_anim);
        in_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),InSign.class));
            }
        });
        up_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),UpSign.class));
            }
        });

    }
}
