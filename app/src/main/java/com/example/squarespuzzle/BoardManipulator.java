package com.example.squarespuzzle;

import android.view.View;

public class BoardManipulator implements View.OnClickListener {

    /*
    * Constructor
    *
     */

    protected BoardInfo[] board;
    public BoardManipulator(BoardInfo[] boardInfo)
    {
        board = boardInfo;
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.reset)
        {

        }

    }

    public BoardInfo initialize(BoardInfo board, int size)
    {
        int temp = size;
        for(int i = 0; i < Math.sqrt((double) size); i++ )
        {
            for(int j = 0; j < Math.sqrt((double) size); j++)
            {
            }
        }
        return board;
    }
}
