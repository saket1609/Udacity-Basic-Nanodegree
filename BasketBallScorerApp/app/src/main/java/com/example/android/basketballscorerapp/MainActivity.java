package com.example.android.basketballscorerapp;


import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  int scoreTeamA = 0 ;
    private int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void displayForTeamA(int score) {

        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {

        TextView scoreView2 = (TextView) findViewById(R.id.team_b_score);
        scoreView2.setText(String.valueOf(score));
    }

    public void ThreePointTeamA(View view) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    public void TwoPointTeamA(View view) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    public void OnePointTeamA(View view) {
        scoreTeamA ++;
        displayForTeamA(scoreTeamA);
    }

    public void ThreePointTeamB(View view) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void TwoPointTeamB(View view) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void OnePointTeamB(View view) {
        scoreTeamB++;
        displayForTeamB(scoreTeamB);
    }

    public void resetScore(View view) {

        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
