package com.example.hashem.eatandeat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.sql.Time;

public class reserveActivity extends Activity {

    CheckBox kidCheck;
    CheckBox vipCheck;
    RadioButton cashRadio;
    RadioButton cardRadio;
    EditText da;
    Spinner stime,etime, tabl;

    Restaurant Res;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        Res = new Restaurant(this);

        tabl = (Spinner)findViewById(R.id.table);
        kidCheck = (CheckBox)findViewById(R.id.kidCheck);
        vipCheck = (CheckBox)findViewById(R.id.vipCheck);
        cashRadio = (RadioButton)findViewById(R.id.cashRadio);
        cardRadio = (RadioButton)findViewById(R.id.cardRadio);
        da = (EditText)findViewById(R.id.Date);
        stime = (Spinner) findViewById(R.id.stime);
        etime = (Spinner) findViewById(R.id.etime);
        Intent i = getIntent();
        id = Integer.parseInt(i.getExtras().get("id").toString());

        Res.getAllTables(tabl);



    }

    public void submitClick(View view) {

        int isVIP, Kids, paymentM;

        String tmp = tabl.getSelectedItem().toString().substring(6, 8).replaceAll("\\s", "");
        int tid = Integer.parseInt(tmp);


        if (!cardRadio.isChecked() && !cashRadio.isChecked()) Toast.makeText(getApplicationContext(), "You must choose a payment method!", Toast.LENGTH_LONG).show();
        else{
            if(cardRadio.isChecked()) paymentM = 1; //1 card    0 cash
            else paymentM = 0;

            if(kidCheck.isChecked()) Kids = 1;
            else Kids = 0;

            if(vipCheck.isChecked()) isVIP = 1;
            else isVIP = 0;

            reserve r = new reserve(0, id, tid, Date.valueOf(da.getText().toString()), Time.valueOf(stime.getSelectedItem().toString()), Time.valueOf(etime.getSelectedItem().toString()), isVIP, Kids, paymentM);
            Res.Reserve(r);
        }
    }

    public void cancelClick(View view) {

        this.finish();

    }
}