package com.example.numerguessinggameandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GussingPage extends AppCompatActivity {
    int range=0;
    TextView ch,wa,hint;
    Button SG;
    int Rg=10;
    Random random=new Random();
    int answer;

    String wrong="SORRY.!! Your Guessing Number is Wrong Try Again..!!";
    String hint1="Hint..Your Answer is ";
    EditText answerguess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gussing_page);
        Intent intent=getIntent();
        int range=intent.getIntExtra("range",0);
        ch=findViewById(R.id.textViewG);
        wa=findViewById(R.id.textViewWa);
        hint=findViewById(R.id.ht);
        SG=findViewById(R.id.ll);
        answerguess=findViewById(R.id.editText);
        if(range==1){
            answer=random.ints(1,9).findFirst().getAsInt();
        }else{
            if(range==2){
                answer=random.ints(10,99).findFirst().getAsInt();
            }else{
                answer=random.ints(100,999).findFirst().getAsInt();
            }
        }

        SG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int guess=Integer.valueOf(answerguess.getText().toString());
                String a=answerguess.getText().toString();
                if(a.length()!=answer){

                }
                if(a.length()>=1&&guess!=answer){
                    Rg--;
                    if(Rg==0){
                        Intent intent1=new Intent(GussingPage.this,Result.class);
                        intent1.putExtra("result",0);
                        startActivity(intent1);
                        finish();
                    }else{
                        ch.setText(""+Rg);
                    }
                    wa.setText(wrong);
                    answerguess.setText("");
                    if(guess<answer){
                        hint.setText(hint1+" Smaller Than Answer");
                    }else{
                        hint.setText(hint1+" Bigger Than Answer");
                    }
                }else{
                    Intent intent1=new Intent(GussingPage.this, Result.class);
                    intent1.putExtra("result",1);
                    startActivity(intent1);
                    finish();
                }
            }
        });

    }
}