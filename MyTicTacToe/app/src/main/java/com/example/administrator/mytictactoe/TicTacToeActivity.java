package com.example.administrator.mytictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TicTacToeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        View startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.start_button:
                Intent gameActivity = new Intent(this,Real_GamePlay.class);
                finish();
                startActivity(gameActivity);
                break;

            case R.id.exit_button:
                Intent mainActivity = new Intent(this,MainActivity.class);
                finish();
                startActivity(mainActivity);
                break;
        }
    }
}
