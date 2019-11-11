/*
 * @author Marc Hilderband
 * @version 11/10/2019
 *
 */

package com.example.squarespuzzle;

import android.view.View;

public class BoardManipulator implements View.OnClickListener {


    private BoardInfo board = new BoardInfo();
    private BoardView guiBoard;


    /*
     * Constructor, creates default board
     */
    public BoardManipulator(BoardView drawBoard)
    {

        //initialize board gui and board array
        board.setBoardSize(16);
        board.resetBoard();
        guiBoard = drawBoard;

        guiBoard.shareBoardInfo(board);
        guiBoard.invalidate();
    }

    /*
    *
     */
    @Override
    public void onClick(View v)
    {
        if(v.getId() ==  R.id.randomize)
        {
            board.randomize();
            guiBoard.invalidate();
        }
        if(v.getId() == R.id.reset)
        {
            board.resetBoard();
            guiBoard.invalidate();
        }
    }


}
