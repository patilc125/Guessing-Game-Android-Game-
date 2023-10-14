package com.example.numerguessinggameandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class HomePage extends AppCompatActivity {

    private Button strat;
    private  RadioButton radio1,radio2,radio3;
    int range=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        strat=findViewById(R.id.buttonStart);
        radio1=findViewById(R.id.radioButton);
        radio2=findViewById(R.id.radioButton2);
        radio3=findViewById(R.id.radioButton3);
        strat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePage.this,GussingPage.class);
                if(radio1.isChecked()){
                    range=1;
                }else{
                    if(radio2.isChecked()){
                        range=2;
                    }else{
                        range=3;
                    }
                }
                if(range!=0){
                    intent.putExtra("range",range);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}