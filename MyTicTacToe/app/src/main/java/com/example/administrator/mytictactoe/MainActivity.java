package com.example.administrator.mytictactoe;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
        View cootieButton = findViewById(R.id.cootieButton);
        cootieButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_about:
                Intent aboutActivity = new Intent(this,AboutActivity.class);
                startActivity(aboutActivity);
                break;

            case R.id.action_app:
                Toast.makeText(this, "App icon clicked!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_help:
                Intent helpActivity = new Intent(this,HelpActivity.class);
                startActivity(helpActivity);
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.start_button:
                Intent startGameActivity = new Intent(this,Real_GamePlay.class);
                finish();
                startActivity(startGameActivity);
                break;

            case R.id.exit_button:
                finish();
                break;

            case R.id.cootieButton:
                Intent startCootieGame = new Intent(this,Cootie_GamePlay.class);
                finish();
                startActivity(startCootieGame);

        }
    }
}
