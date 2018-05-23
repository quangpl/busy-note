package com.example.plquang.busynote;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Welcome extends AppCompatActivity {
ImageView button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        final Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
       button=(ImageView) findViewById(R.id.btn);

       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.startAnimation(animation);
                Intent intent=new Intent(Welcome.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
