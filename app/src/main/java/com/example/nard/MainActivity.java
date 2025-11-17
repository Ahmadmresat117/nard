package com.example.nard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView number;
    private Button start;
    private Button newGame;
    private boolean isStart = false;
private TextView random1,random2,random3,random4,random5,random6,score;
    private int random11,random21,random31,random41,random51,random61,count=0;
    private Handler handler = new Handler();
    private Random random = new Random();
    public static int countCorrect=0;
    public static int numberGames=0;
    private Button btnScore;
    private Intent intent;
    private EditText name;
private int counter;

    private int displayedNumber = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScore = findViewById(R.id.next);
        intent = new Intent(MainActivity.this, nard2.class);

        number = findViewById(R.id.number1);
        name=findViewById(R.id.name);
        start = findViewById(R.id.Start);
        newGame = findViewById(R.id.New);
        random1=findViewById(R.id.random1);
        random2=findViewById(R.id.random2);
        random3=findViewById(R.id.random3);
        random4=findViewById(R.id.random4);
        random5=findViewById(R.id.random5);
        random6=findViewById(R.id.random6);
        score=findViewById(R.id.score);
        number.setText("0");
        start.setText("START");
        start.setBackgroundColor(Color.GREEN);
        random11=(int)(Math.random()*(100 - 10 + 1))+ 10;
        random21=(int)(Math.random()*(100 - 10 + 1))+ 10;
        random31=(int)(Math.random()*(100 - 10 + 1))+ 10;
        random41=(int)(Math.random()*(100 - 10 + 1))+ 10;
        random51=(int)(Math.random()*(100 - 10 + 1))+ 10;
        random61=(int)(Math.random()*(100 - 10 + 1))+ 10;
        random1.setText(random11+"") ;
        random2.setText(random21+"");
        random3.setText(random31+"");
        random4.setText(random41+"") ;
        random5.setText(random51+"");
        random6.setText(random61+"");


        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int randNumber = random.nextInt(99) + 1;
                displayedNumber = randNumber;
                number.setText(String.valueOf(randNumber));
                handler.postDelayed(this, 100);
            }
        };
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                random11=(int)(Math.random()*(100 - 10 + 1))+ 10;
                random21=(int)(Math.random()*(100 - 10 + 1))+ 10;
                random31=(int)(Math.random()*(100 - 10 + 1))+ 10;
                random41=(int)(Math.random()*(100 - 10 + 1))+ 10;
                random51=(int)(Math.random()*(100 - 10 + 1))+ 10;
                random61=(int)(Math.random()*(100 - 10 + 1))+ 10;
                random1.setText(random11+"") ;
                random2.setText(random21+"");
                random3.setText(random31+"");
                random4.setText(random41+"") ;
                random5.setText(random51+"");
                random6.setText(random61+"");
                random1.setBackgroundColor(Color.WHITE);
                random2.setBackgroundColor(Color.WHITE);
                random3.setBackgroundColor(Color.WHITE);
                random4.setBackgroundColor(Color.WHITE);
                random5.setBackgroundColor(Color.WHITE);
                random6.setBackgroundColor(Color.WHITE);
                counter=0;
                score.setText(0+"of 6");
                numberGames++;
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isStart) {
                    isStart = true;
                    start.setText("STOP");
                    start.setBackgroundColor(Color.RED);
                    handler.post(runnable);
                    counter++;
                } else {
                    isStart = false;
                    start.setText("START");
                    start.setBackgroundColor(Color.GREEN);
                    handler.removeCallbacks(runnable);

                }
                if (isStart==false){
                    if(displayedNumber==random11||displayedNumber==random21||displayedNumber==random31||displayedNumber==random41||displayedNumber==random51){
                    count++;
                    score.setText(count+"of 6");
                }}
                if(displayedNumber==random11){
                    random1.setBackgroundColor(Color.RED);
                    random11=-1;
                    countCorrect++;
                }
                if(displayedNumber==random21){
                    random2.setBackgroundColor(Color.RED);
                    random21=-1;
                    countCorrect++;
                }
                if(displayedNumber==random31){
                    random3.setBackgroundColor(Color.RED);
                    random31=-1;
                    countCorrect++;
                }
                if(displayedNumber==random41){
                    random4.setBackgroundColor(Color.RED);
                    random41=-1;
                    countCorrect++;
                }
                if(displayedNumber==random51){
                    random5.setBackgroundColor(Color.RED);
                    random51=-1;
                    countCorrect++;
                }
                if(displayedNumber==random61){
                    random6.setBackgroundColor(Color.RED);
                    random61=-1;
                    countCorrect++;
                }

            if (counter>=6){
                score.setText("0of 6");
                random11=(int)(Math.random()*(100 - 10 + 1))+ 10;
                random21=(int)(Math.random()*(100 - 10 + 1))+ 10;
                random31=(int)(Math.random()*(100 - 10 + 1))+ 10;
                random41=(int)(Math.random()*(100 - 10 + 1))+ 10;
                random51=(int)(Math.random()*(100 - 10 + 1))+ 10;
                random61=(int)(Math.random()*(100 - 10 + 1))+ 10;
                random1.setText(random11+"") ;
                random2.setText(random21+"");
                random3.setText(random31+"");
                random4.setText(random41+"") ;
                random5.setText(random51+"");
                random6.setText(random61+"");
                counter=0;
                Toast.makeText(MainActivity.this, "you can't press more than 6 times", Toast.LENGTH_SHORT).show();
                score.setText(0+"of 6");
                numberGames++;
            }
            }
        });

        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("NAME",name.getText().toString());
                startActivity(intent);

            }
        });
    }

}
