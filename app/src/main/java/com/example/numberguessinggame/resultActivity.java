package com.example.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {
    TextView userNamePlayer,score;
    Button playAgain;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //Finding id's
        userNamePlayer = findViewById(R.id.txtPlayerName);
//        score = findViewById(R.id.txtScore);
        playAgain = findViewById(R.id.btnPlayAgain);

        Intent intent = new Intent(this,MainActivity.class);
        Intent getData = getIntent();
//        String Guess = getData.getStringExtra("guess");
//        int Guess = getData.getIntExtra("guess",5);
        String userName = getData.getStringExtra("userName");

        userNamePlayer.setText(userName);
//        Log.d("Debug", "Ngusses received in resultActivity: " + Guess);
//        score.setText("You guessed in "+Guess+ " attempts.");

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}