package com.example.hashem.eatandeat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class signin extends Activity {

    EditText un, p;
    CheckBox accept;
    Restaurant res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        un = (EditText) findViewById(R.id.EditUN);
        p = (EditText) findViewById(R.id.EditP);
        accept = (CheckBox) findViewById(R.id.Accept);

        res = new Restaurant(this);

    }

    public void signin(View view) {
        if(!un.getText().toString().isEmpty() && !p.getText().toString().isEmpty()) {
            res.signin(un.getText().toString(), p.getText().toString(), choicesActivity.class);
        }
        else Toast.makeText(this, "Please Fill All Requirements!", Toast.LENGTH_SHORT).show();
    }

    public void signup(View view) {
        if(accept.isChecked() && !un.getText().toString().isEmpty() && !p.getText().toString().isEmpty()) {
            res.signup(new user(0, un.getText().toString(), p.getText().toString()));
        }
        else Toast.makeText(this, "Please Fill All Requirements!", Toast.LENGTH_SHORT).show();

    }
}
