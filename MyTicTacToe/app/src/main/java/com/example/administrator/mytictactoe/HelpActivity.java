package com.example.administrator.mytictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HelpActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        View backButton = findViewById(R.id.help_back);
        backButton.setOnClickListener(this);
    }
    public void onClick(View v) {
        Intent mainScreenActivity = new Intent(this,MainActivity.class);
        finish();
        startActivity(mainScreenActivity);
    }
}
