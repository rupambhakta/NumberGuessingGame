package com.example.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    AppCompatEditText edtUserName;
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUserName = findViewById(R.id.edtName);
        btnStart = findViewById(R.id.btnStart);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = Objects.requireNonNull(edtUserName.getText()).toString();
                if (userName.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter your name.", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MainActivity.this,GameActivity.class);
                    intent.putExtra("userName",userName);
                    startActivity(intent);
                }
            }
        });
    }
}