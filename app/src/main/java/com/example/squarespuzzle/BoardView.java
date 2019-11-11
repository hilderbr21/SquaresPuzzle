package com.example.squarespuzzle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class BoardView extends SurfaceView {

    BoardInfo board;
    Paint textColor = new Paint();



    public BoardView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        setWillNotDraw(false);

    }

    @Override
    public void onDraw(Canvas canvas)
    {
        setBackgroundColor(Color.WHITE);
        for(int i = 0; i < board.getBoardSize(); i++)
        {
            drawSquare(canvas, (int) (i%(Math.sqrt(board.getBoardSize()))), (int) (i/Math.sqrt(board.getBoardSize())), board.getNumber(i));
            invalidate();
        }


    }

    private void drawSquare(Canvas canvas, int x, int y, int value)
    {
        x = (10+x)*20;
        y = (10+y)*20;

        //canvas.drawRect();
        canvas.drawText(String.valueOf(value), (float) x, (float) y, textColor);
    }

    /*
    * used for updating board when BoardManipulator class changes data
    *
    *  @param info new board data
     */
    public void shareBoardInfo(BoardInfo info)
    {
        board = info;
    }
}
