/*
 *@author Marc Hilderbrand
 * Version 11/11/2019
 *
 * Contains an integer array containing ints for the game.
 * This class also contains methods to be called to manipulate the array.
 * Holds win status as a boolean
 */

package com.example.squarespuzzle;

public class BoardInfo {

    private int[] boardNums = new int[25];
    private int boardSize = 16;
    private boolean win = false;

    /*swapNums
    * swaps two numbers at specified positions
    *
    * @param oldPosition
    * @param newPosition
    *
     */
    public void swapNums(int oldPosition, int newPosition)
    {
        if(oldPosition >= boardSize || newPosition >= boardSize)
        {
            System.out.println("Error: attempted to swap out of bounds");
        }
        else
        {
            int temp = getNumber(oldPosition);
            setNumber(oldPosition, getNumber(newPosition));
            setNumber(newPosition, temp);

        }
    }

    /* resetBoard
    * resets array to numerical order thus putting the board to its winning state
     */
    public void resetBoard()
    {
        for(int i = 0; i < getBoardSize()-1; i++ )
        {
            setNumber(i,(i+1));
        }
        setNumber(getBoardSize()-1,0);
    }

    /* randomize
     * swaps random numbers 100 times
     */
    public void randomize()
    {

        for(int i = 0; i <100; i++)
        {
            swapNums((int) (Math.random()*(boardSize)),(int) (Math.random()*(boardSize)));
        }
    }

    /* getNumber
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

    /* setNumber
    * Writes a new number at array position
    *
    * @param position   The position on the array of the number
    * @param newNumber  The new number to be written at positions on the array
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

    /*getArrayPosition
    * returns position on array given coordinates
    *
    * @param x  x coordinate
    * @param y  y coordinate
    *
    * @return -2  if out of bounds
    * @return
     */
    public int getArrayPosition(int x, int y)
    {
        if(x < 0 || y < 0)
        {
            return -2;
        }
        int yCoord = (y%(int)Math.sqrt(getBoardSize()));
        int xCoord = (x%(int)Math.sqrt(getBoardSize()))+1;

        int position = (yCoord*4) + xCoord;
        return (position-1);
    }

    /* checkForSwap
     * checks for 0 next to or 4 before/after parameter number
     *
     * @param position position on array to be checked
     *
     * @return int of position that could be swapped
     * @return -1 there is not move to be made
     */
    public int checkForSwap(int position)
    {
        //check down
        if(position + 4 < getBoardSize())
        {
            if (boardNums[position+4] == 0)
            {
                return (position+4);
            }
        }

        //check right
        if(position + 1 < getBoardSize())
        {
            if(boardNums[position+1] == 0)
            {
                if((position+1)%(Math.sqrt(getBoardSize())) != 0)
                {
                    return (position+1);
                }

            }
        }

        //check up
        if(position - 4 >= 0)
        {
            if(boardNums[position - 4] == 0)
            {
                return (position-4);
            }
        }

        //check left
        if(position - 1 >= 0)
        {
            if(boardNums[position - 1] == 0)
            {
                if((position-1)%(Math.sqrt(getBoardSize())) != Math.sqrt(getBoardSize())-1)
                {
                    return (position - 1);
                }
            }
        }
        return -1;
    }

    /* checkWin
     * changes status to win if winning conditions are met
     */
    public void checkWin()
    {
        win = true;
        for(int i = 0; i < getBoardSize()-1; i++ )
        {
            if(boardNums[i] == i+1 && win)
            {
                win = true;
            }
            else
            {
                win = false;
            }

        }

    }

    /* getWinStatus
     * returns status of win
     */
    public boolean getWinStatus()
    {
        return win;
    }

    /* setWinFalse
     * manually set win to false
     */
    public void setWinFalse()
    {
        win = false;
    }

    /* setBoardSize & getBoardSize
    * getter and setter methods to get the size of the board to be used in calculations.
    *
    * A separate variable for board size is used to to allow for different size boards for future versions
     */
    public void setBoardSize(int boardSize) { this.boardSize = boardSize; }

    public int getBoardSize() { return boardSize; }

}
