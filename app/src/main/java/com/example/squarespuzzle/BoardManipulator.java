/*
 * @author Marc Hilderband
 * @version 11/11/2019
 *
 * When called in MainActivity, initializes the board and BoardView to default winning state
 * Contains all the listeners in the program.
 */

package com.example.squarespuzzle;

import android.view.MotionEvent;
import android.view.View;

public class BoardManipulator implements View.OnClickListener, View.OnTouchListener {


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

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        int valueFromTap = whatWasTapped(event);
        if(valueFromTap < 0)
        {
            return false;
        }

        int adjacentNum = board.checkLegalMove(valueFromTap);
        if(adjacentNum >= 0)
        {
            board.swapNums(valueFromTap, adjacentNum);
            return true;
        }

        return false;

    }


    /*
    * takes coords of tap event and returns number tapped
    *
    * @param event
    *
    * @returns value of number tapped
    * @returns -1 if out of bounds
    * @returns -2 if coordinate is not covered in method
     */
    private int whatWasTapped(MotionEvent event)
    {
        int x = (int) event.getX();
        int y = (int) event.getY();

        //Check boundaries
        if(x < 325 || y <100)
        {
            return -1;
        }
        if(x > 325*4 || y > 325*4)
        {
            return -1;
        }

        //use simple coordinates to determine square tapped
        int simpleX;
        int simpleY;
        if(x >= 325 && x < 325 + 150)
        {
            simpleX = 0;
        }
        else if(x >= 325 + 150 && x < 325 + (150*2))
        {
            simpleX = 1;
        }
        else if(x >= 325 + (150*2) && x < 325 + (150*3))
        {
            simpleX = 2;
        }
        else if(x >= 325 + (150*3) && x < 325 + (150*4))
        {
            simpleX = 3;
        }
        else
        {
            simpleX = -1;
        }


        if(y >= 100 && x < 100 + 150)
        {
            simpleY = 0;
        }
        else if(y >= 100 + 150 && x < 100 + (150*2))
        {
            simpleY = 1;
        }
        else if(y >= 100 + (150*2) && x < 100 + (150*3))
        {
            simpleY = 2;
        }
        else if(y >= 100 + (150*3) && x < 100 + (150*4))
        {
            simpleY = 3;
        }
        else
        {
            simpleY = -1;
        }

        return board.getArrayPosition(simpleX,simpleY);

    }



}
