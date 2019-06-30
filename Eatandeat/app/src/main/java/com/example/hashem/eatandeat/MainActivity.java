package com.example.hashem.eatandeat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;

public class MainActivity extends Activity {
    ImageButton welcomeImage;
    View v;
    Switch s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    welcomeImage = (ImageButton)findViewById(R.id.welcomeImage);
    v = this.getWindow().getDecorView();
    v.setBackgroundResource(R.color.myRed);
        s = (Switch)findViewById(R.id.switch1);

    }

    public void welcomeClick(View view) {
    startActivity(new Intent(MainActivity.this, signin.class));



    }

    public void nightSwitch(View view) {
        if(s.isChecked()){
            v.setBackgroundResource(R.color.mydarkRed);
        }
        else if (!s.isChecked())v.setBackgroundResource(R.color.myRed);

    }

}
