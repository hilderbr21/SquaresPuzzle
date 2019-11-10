/*
 * @author Marc Hilderband
 * @version 11/9/2019
 *
 */

package com.example.squarespuzzle;

import android.view.View;

public class BoardManipulator implements View.OnClickListener {


    private BoardInfo board = new BoardInfo();
    private DrawBoard = new DrawBoard();

    /* Constructor
     *
     *
     */
    public BoardManipulator(DrawBoard boardGui, BoardInfo theBoard, int size)
    {

        //initialize board gui and board array
        guiBoard = boardGui;
        board = theBoard;
        board.setBoardSize(size);
        for(int i = 0; i < board.getBoardSize(); i++ )
        {
            board.setNumber(i,(i+1));
        }
        board.setNumber(board.getBoardSize(),0);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.reset)
        {
            board.randomize();
        }
    }

}
