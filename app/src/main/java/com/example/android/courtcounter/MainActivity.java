package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView scoreViewA, scoreViewB;
    private int scoreTeamA = 0, scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
        //displayForTeamA(8);
    }

    /** This method is right before we change orientation, to preserve values */
    @Override
    protected void onSaveInstanceState (Bundle outState){

        super.onSaveInstanceState(outState);

        outState.putInt("TeamA",scoreTeamA);
        outState.putInt("TeamB",scoreTeamB);
    }

    /** This method is called to display values in the UI which were saved */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        scoreTeamA = savedInstanceState.getInt("TeamA");
        displayForTeamA(scoreTeamA);
        scoreTeamB = savedInstanceState.getInt("TeamB");
        displayForTeamB(scoreTeamB);
    }

    /** This Method is called when +3 Points button is clicked **/
    public void threePointerA(View view){

        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }
    public void threePointerB(View view){

        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    /** This Method is called when +2 Points button is clicked **/
    public void twoPointerA(View view){

        scoreTeamA +=2;
        displayForTeamA(scoreTeamA);
    }
    public void twoPointerB(View view){

        scoreTeamB +=2;
        displayForTeamB(scoreTeamB);
    }

    /** This Method is called when Free Throw button is clicked **/
    public void freeThrowA(View view){

        scoreTeamA +=1;
        displayForTeamA(scoreTeamA);
    }
    public void freeThrowB(View view){

        scoreTeamB +=1;
        displayForTeamB(scoreTeamB);
    }

    /** Displays the given score for Team A */
    public void displayForTeamA(int score) {
        //TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreViewA.setText(String.valueOf(score));
    }

    /** Displays the given score for Team B */
    public void displayForTeamB(int score) {

        scoreViewB.setText(String.valueOf(score));
    }

    /** This Method is called when Reset button is clicked **/
    public void resetScore(View view){

        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
