package com.example.android.volleyballcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int pointsA = 0;
    public int pointsB = 0;
    public int setsWonA = 0;
    public int setsWonB = 0;
    public int pointsToWin = 25;



//    ADDS 1 POINT FOR TEAM A
    public void addOneForA(View v) {
        pointsA++;
        displayPointsForA();
    }

    public void displayPointsForA() {
        TextView pointsAView = (TextView) findViewById(R.id.points_A_View);
        pointsAView.setText(String.valueOf(pointsA));

        if (pointsA >= pointsToWin && (pointsA - pointsB >= 2)) {
            addWonSetForA();
            if (setsWonA != 3) {
                Toast.makeText(this, R.string.set_for_A, Toast.LENGTH_SHORT).show();
                resetSetPoints();
            } else {
                Toast.makeText(this, R.string.match_for_A, Toast.LENGTH_SHORT).show();
                resetSetPoints();
                resetSetsWon();
            }
        }

        if (setsWonA == 2 && setsWonB == 2) {
            pointsToWin = 15;
        }
    }


//    ADDS 1 WON SET FOR TEAM A
    public void addWonSetForA() {
        setsWonA++;
        displaySetsWonForA();
    }

    public void displaySetsWonForA() {
        TextView setsWonAView = (TextView) findViewById(R.id.sets_Won_A_View);
        setsWonAView.setText(String.valueOf(setsWonA));
    }



//    ADDS 1 POINT FOR TEAM B
    public void addOneForB(View v) {
        pointsB++;
        displayPointsForB();
    }

    public void displayPointsForB() {
        TextView pointsBView = (TextView) findViewById(R.id.points_B_View);
        pointsBView.setText(String.valueOf(pointsB));

        if (pointsB >= pointsToWin && (pointsB - pointsA >= 2)) {
            addWonSetForB();
            if (setsWonB != 3) {
                Toast.makeText(this, R.string.set_for_B, Toast.LENGTH_SHORT).show();
                resetSetPoints();
            } else {
                Toast.makeText(this, R.string.match_for_B, Toast.LENGTH_SHORT).show();
                resetSetPoints();
                resetSetsWon();
            }
        }

        if (setsWonA == 2 && setsWonB == 2) {
            pointsToWin = 15;
        }
    }


//    ADDS 1 WON SET FOR TEAM B
    public void addWonSetForB() {
        setsWonB++;
        displaySetsWonForB();
    }

    public void displaySetsWonForB() {
        TextView setsWonBView = (TextView) findViewById(R.id.sets_Won_B_View);
        setsWonBView.setText(String.valueOf(setsWonB));
    }



// RESETS ALL POINTS AND WON SETS
    public void resetAll(View view) {
        resetSetPoints();
        resetSetsWon();
        pointsToWin = 25;
    }

    public void resetSetPoints() {
        pointsA = 0;
        TextView pointsAView = (TextView) findViewById(R.id.points_A_View);
        pointsAView.setText(String.valueOf(pointsA));

        pointsB = 0;
        TextView pointsBView = (TextView) findViewById(R.id.points_B_View);
        pointsBView.setText(String.valueOf(pointsB));
    }

    public void resetSetsWon() {
        setsWonA = 0;
        TextView setsWonAView = (TextView) findViewById(R.id.sets_Won_A_View);
        setsWonAView.setText(String.valueOf(setsWonA));

        setsWonB = 0;
        TextView setsWonBView = (TextView) findViewById(R.id.sets_Won_B_View);
        setsWonBView.setText(String.valueOf(setsWonB));
    }
}