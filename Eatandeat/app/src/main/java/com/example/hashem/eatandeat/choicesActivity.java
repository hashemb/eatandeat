package com.example.hashem.eatandeat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class choicesActivity extends Activity {
View v;
Switch s;
int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);

        v = this.getWindow().getDecorView();
        v.setBackgroundResource(R.color.myRed);

        Intent i = getIntent();
        id = Integer.parseInt(i.getExtras().get("id").toString());

    }

    public void reserveClick(View view) {
        Intent i = new Intent(choicesActivity.this, reserveActivity.class);
        i.putExtra("id", id);
        startActivity(i);

    }

    public void samplesClick(View view) {
        startActivity(new Intent(choicesActivity.this, SamplesActivity.class));

    }


    public void opinionClick(View view) {
        startActivity(new Intent(choicesActivity.this, MapsActivity.class));
    }
}
