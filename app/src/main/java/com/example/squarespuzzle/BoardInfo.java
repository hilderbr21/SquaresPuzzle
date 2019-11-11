/*
 *@author Marc Hilderbrand
 * Version 11/10/2019
 */

package com.example.squarespuzzle;

import java.util.Hashtable;

public class BoardInfo {


    private int[] boardNums = new int[25];
    private int boardSize = 16;

    /*
    * swaps two numbers at specified positions
    *
    * @param oldPosition
    * @param newPosition
    *
     */
    public void swapNums(int oldPosition, int newPosition)
    {
        if(oldPosition > boardSize || newPosition > boardSize)
        {
            System.out.println("Error: attempted to swap out of bounds");
        }
        else
        {
            int temp = getNumber(oldPosition);
            setNumber(newPosition, temp);
        }
    }

    public void resetBoard()
    {
        for(int i = 0; i < getBoardSize(); i++ )
        {
            setNumber(i,(i+1));
        }
        setNumber(getBoardSize(),0);
    }

    public void randomize()
    {
        //randomize the board
    }

    /*
    * checks boundaries and returns number at specific position
    *
    * @param position   Position to be checked
    *
    * @return -1 if out of bounds and the position otherwise
     */
    public int getNumber(int position)
    {
        if(position >= boardSize)
        {
            return -1;
        }
        else
        {
            return boardNums[position];
        }
    }

    /*
    *
    *
    *
     */
    public void setNumber(int position, int newNumber)
    {
        if(position > boardSize)
        {
            System.out.println("Error: attempted to set a number out of bounds");
    }
        else
        {
            boardNums[position] = newNumber;
        }
    }

    public void setBoardSize(int boardSize)
    {
        this.boardSize = boardSize;
    }

    public int getBoardSize()
    {
        return boardSize;
    }

}
