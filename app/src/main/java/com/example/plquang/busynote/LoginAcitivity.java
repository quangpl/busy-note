package com.example.plquang.busynote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginAcitivity extends AppCompatActivity {
Button btnlog;
Button btnreg;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acitivity);
btnlog= (Button) findViewById(R.id.btnLog);
btnlog.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(LoginAcitivity.this, MainActivity.class);
        startActivity(intent);
    }
});

    }

}
