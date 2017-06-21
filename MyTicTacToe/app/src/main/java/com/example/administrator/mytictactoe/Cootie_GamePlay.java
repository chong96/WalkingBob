package com.example.administrator.mytictactoe;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Cootie_GamePlay extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cootie__game_play);

        final Cootie player1 = new Cootie();
        final Cootie player2 = new Cootie();
        final int[] count = {0};

        View rollButton = (Button)findViewById(R.id.realRollButton);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!player1.isDone() && !player2.isDone()) {
                    int roll = (int) roll();
                    Toast.makeText(Cootie_GamePlay.this, "You rolled a " + roll, Toast.LENGTH_SHORT).show();
                    if (count[0] % 2 == 0) {

                        switch (roll) {

                            case 1:
                                if (!player1.hasBody) {
                                    player1.hasBody = true;
                                    Toast.makeText(Cootie_GamePlay.this, "You now have a body!", Toast.LENGTH_SHORT).show();
                                    break;
                                } else {
                                    count[0]++;
                                    Toast.makeText(Cootie_GamePlay.this, "You already have a body, switching turns", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            case 2:
                                if (player1.hasBody && !player1.hasHead) {
                                    player1.hasHead = true;
                                    player1.hasBoth = true;
                                    Toast.makeText(Cootie_GamePlay.this, "You now have a head!", Toast.LENGTH_SHORT).show();
                                    break;
                                } else {
                                    count[0]++;
                                    Toast.makeText(Cootie_GamePlay.this, "Switching turns", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            case 3:
                                if (player1.hasBoth) {
                                    player1.antennae = true;
                                    Toast.makeText(Cootie_GamePlay.this, "You now have an antennae", Toast.LENGTH_SHORT).show();
                                    break;
                                } else {
                                    count[0]++;
                                    Toast.makeText(Cootie_GamePlay.this, "Switching turns", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            case 4:
                                if (player1.hasBoth && player1.eyes != 2) {
                                    player1.eyes++;
                                    Toast.makeText(Cootie_GamePlay.this, "You just added an eye!", Toast.LENGTH_SHORT).show();
                                    break;
                                } else {
                                    count[0]++;
                                    Toast.makeText(Cootie_GamePlay.this, "Switching turns", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            case 5:
                                if (player1.hasBoth) {
                                    player1.teeth = true;
                                    Toast.makeText(Cootie_GamePlay.this, "You just got teeth!", Toast.LENGTH_SHORT).show();
                                    break;
                                } else {
                                    count[0]++;
                                    Toast.makeText(Cootie_GamePlay.this, "Switching turns", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            case 6:
                                if (player1.hasBoth && player1.legs != 6) {
                                    player1.legs++;
                                    Toast.makeText(Cootie_GamePlay.this, "You just got a leg!", Toast.LENGTH_SHORT).show();
                                    break;
                                } else {
                                    count[0]++;
                                    Toast.makeText(Cootie_GamePlay.this, "Switching turns", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                        }
                    } else {

                        switch (roll) {

                            case 1:
                                if (!player2.hasBody) {
                                    player2.hasBody = true;
                                    Toast.makeText(Cootie_GamePlay.this, "You now have a body!", Toast.LENGTH_SHORT).show();
                                    break;
                                } else {
                                    count[0]++;
                                    Toast.makeText(Cootie_GamePlay.this, "Switching turns", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            case 2:
                                if (player2.hasBody && !player2.hasHead) {
                                    player2.hasHead = true;
                                    player2.hasBoth = true;
                                    Toast.makeText(Cootie_GamePlay.this, "You now have a head!", Toast.LENGTH_SHORT).show();
                                    break;
                                } else {
                                    count[0]++;
                                    Toast.makeText(Cootie_GamePlay.this, "Switching turns", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            case 3:
                                if (player2.hasBoth) {
                                    player2.antennae = true;
                                    Toast.makeText(Cootie_GamePlay.this, "You now have a body!", Toast.LENGTH_SHORT).show();
                                    break;
                                } else {
                                    count[0]++;
                                    Toast.makeText(Cootie_GamePlay.this, "Switching turns", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            case 4:
                                if (player2.hasBoth && player2.eyes != 2) {
                                    player2.eyes++;
                                    Toast.makeText(Cootie_GamePlay.this, "You just added an eye!", Toast.LENGTH_SHORT).show();
                                    break;
                                } else {
                                    count[0]++;
                                    Toast.makeText(Cootie_GamePlay.this, "Switching turns", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            case 5:
                                if (player2.hasBoth) {
                                    player2.teeth = true;
                                    Toast.makeText(Cootie_GamePlay.this, "You just added teeth!", Toast.LENGTH_SHORT).show();
                                    break;
                                } else {
                                    count[0]++;
                                    Toast.makeText(Cootie_GamePlay.this, "Switching turns", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            case 6:
                                if (player2.hasBoth && player2.legs != 6) {
                                    player2.legs++;
                                    Toast.makeText(Cootie_GamePlay.this, "You just added a leg!", Toast.LENGTH_SHORT).show();
                                    break;
                                } else {
                                    count[0]++;
                                    Toast.makeText(Cootie_GamePlay.this, "Switching turns", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                        }
                    }
                }

                AlertDialog.Builder alertDialogBulider = new AlertDialog.Builder(Cootie_GamePlay.this);
                if (player1.isDone() || player2.isDone()) {
                    if (player1.isDone()) {
                        alertDialogBulider.setMessage("Player 1 won!");
                        AlertDialog alertDialog = alertDialogBulider.create();
                        alertDialog.show();
                    } else {
                        alertDialogBulider.setMessage("Player 2 won!");
                        AlertDialog alertDialog = alertDialogBulider.create();
                        alertDialog.show();
                    }
                }
            }
        });
    }


    private double roll(){
        return((6.0 * Math.random()) + 1);
    }

    public class Cootie {
        boolean hasBody;
        boolean hasHead;
        boolean hasBoth;
        boolean antennae;
        boolean teeth;
        int legs;
        int eyes;


        public Cootie() {
            hasBody = false;
            hasHead = false;
            hasBoth = false;
            antennae = false;
            teeth = false;
            legs = 0;
            eyes = 0;
        }

        public boolean isDone() {
            boolean isDone = false;
            if (hasBoth && antennae && teeth && legs == 6 && eyes == 2){
                isDone = true;
            }
            return isDone;
        }

    }
}
