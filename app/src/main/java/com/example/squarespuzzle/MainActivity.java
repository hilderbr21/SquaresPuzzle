/*
 * @author Marc Hilderband
 * @version 11/9/2019
 *
 */
package com.example.squarespuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        BoardInfo board = new BoardInfo();
        BoardManipulator boardManip = new BoardManipulator(board, 16);

        View resetButton = findViewById(R.id.reset);
        resetButton.setOnClickListener(boardManip);


    }
}
