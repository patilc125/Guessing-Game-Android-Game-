package com.example.numerguessinggameandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    Button PA,Exit;
    TextView result1;
    int result=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        PA=findViewById(R.id.btnPa);
        Exit=findViewById(R.id.btnExit);
        result1=findViewById(R.id.textView4);

        Intent intent=getIntent();
        result=intent.getIntExtra("result",0);
        if(result==0){
            result1.setText("Sorry..!! You Loss The Game");
        }else{
            result1.setText("Congratulation..!! You Win The Game");
        }
        PA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent1=new Intent(Result.this, HomePage.class);
                 startActivity(intent1);
                 finish();
            }
        });
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}