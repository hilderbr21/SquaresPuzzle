/*
 * @author Marc Hilderband
 * @version 11/10/2019
 *
 */
package com.example.squarespuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        BoardInfo boardInfo = new BoardInfo();
        /**
         External Citation
         Date: 10 Novermber 2019
         Problem: Unexpected implicit cast to BoardView: layout tag was SurfaceView
         Original code: BoardView boardView = findViewById(R.id.theBoard);
         Resource: https://stackoverflow.com/questions/31794136/textview-cannot-be-cast-to-edittext
         Solution: Had to change SurfaceView to BoardView in the XML
         */
        BoardView boardView = boardView = findViewById(R.id.theBoard);
        BoardManipulator boardManip = new BoardManipulator(boardView);

        View resetButton = findViewById(R.id.reset);
        View randomizeButton = findViewById(R.id.randomize);
        resetButton.setOnClickListener(boardManip);
        randomizeButton.setOnClickListener(boardManip);

    }
}
