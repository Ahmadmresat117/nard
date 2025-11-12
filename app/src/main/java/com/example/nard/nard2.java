package com.example.nard;

import android.content.Intent;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class nard2 extends AppCompatActivity {
private TextView games;
private TextView correct;
private Intent nard1;
private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nard2);
        games=findViewById(R.id.games);
        correct=findViewById(R.id.correct);
        back=findViewById(R.id.back);

        games.setText("number of games: " + MainActivity.numberGames);
        correct.setText("number of correct answers: " + MainActivity.countCorrect);

        nard1=new Intent(nard2.this, MainActivity.class);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(nard1);
            }
        });


    }
}