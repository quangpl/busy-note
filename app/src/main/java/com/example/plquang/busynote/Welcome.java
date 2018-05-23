package com.example.plquang.busynote;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Welcome extends AppCompatActivity {
Animation animation;
View layout;
private static  int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {


                                          Intent homeIntent = new Intent(Welcome.this, MainActivity.class);
                                          startActivity(homeIntent);
                                          overridePendingTransition(R.anim.out,R.anim.trans);
                                          finish();
                                      }
                                  },SPLASH_TIME_OUT);
        /*final Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
       button=(ImageView) findViewById(R.id.btn);

       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.startAnimation(animation);
                Intent intent=new Intent(Welcome.this,MainActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
