package com.example.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    AppCompatEditText edtNumber;
    TextView suggestion,txtResult;
    Button btnSubmit;
    int number, Nguesses;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //Finding id's
        edtNumber = findViewById(R.id.edtNumber);
        suggestion = findViewById(R.id.txtSuggestion);
        btnSubmit =findViewById(R.id.btnSubmit);
        txtResult = findViewById(R.id.txtResult);

        Intent intent = new Intent(this,resultActivity.class);
        Intent getData = getIntent();
        String userName = getData.getStringExtra("userName");
        intent.putExtra("userName",userName);
        intent.putExtra("guess", Nguesses);

        Random random = new Random();
        number = random.nextInt(100)+1;
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guessText = edtNumber.getText().toString();
                if (!guessText.isEmpty()) {
                    int guess = Integer.parseInt(guessText);

                    if (guess < number) {
                        suggestion.setText("Higher number please !");
                    } else if (guess > number) {
                        suggestion.setText("Lower number please !");
                    } else {
                        Log.i("Value of guess", String.valueOf(Nguesses));
//                        txtResult.setText("You guessed in "+Nguesses+ " attempts.");
                        Toast.makeText(GameActivity.this, "You guessed in " + Nguesses + " attempts.", Toast.LENGTH_SHORT).show();
                        Toast.makeText(GameActivity.this, "You guessed in " + Nguesses + " attempts.", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }
                    Nguesses++;
                    edtNumber.setText("");
                } else {
                    suggestion.setText("Please enter a number.");
                    Toast.makeText(GameActivity.this, "First Enter A Number!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


}