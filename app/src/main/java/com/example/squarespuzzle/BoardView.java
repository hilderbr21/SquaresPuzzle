package com.example.squarespuzzle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class BoardView extends SurfaceView {

    private BoardInfo board;
    private Paint textColor = new Paint();
    private Paint squarePaint = new Paint();


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
            drawSquare(canvas, board.getNumber(i), i);
            invalidate();
        }
    }

    /*
     * draws squares filled with numbers based on location in array,
     *
     * @param canvas   the canvas to be drawn to
     * @param value    the value held in the square
     * @param position the position of the square along the array
     *
     */
    private void drawSquare(Canvas canvas, int value, int position)
    {

        int x = 325+ 150*(position%((int)(Math.sqrt(board.getBoardSize()))));
        int y = 100+ 150*(position/((int)(Math.sqrt(board.getBoardSize()))));


        //canvas.drawRect();

        /**
         External Citation
         Date: 10 Novermber 2019
         Problem: Font size too small
         Resource: https://android--examples.blogspot.com/2015/11/android-how-to-draw-text-on-canvas.html
         Solution: use method setTextSize(int) on paint variable
         */
        textColor.setTextSize(50);

        /**
         External Citation
         Date: 10 Novermber 2019
         Problem: needed a rectangle that was just a border
         Resource: https://stackoverflow.com/questions/13545792/drawing-a-filled-rectangle-with-a-border-in-android
         Solution: use method paint.setStyle(Paint.Style.STROKE);
         */
        Rect square = new Rect(x-50,y-70,x+100,y+50);
        squarePaint.setStyle(Paint.Style.STROKE);


        //draw draw an empty square if value = 0
        if(value == 0)
        {
            canvas.drawRect(square,squarePaint);
        }
        else
        {
            canvas.drawText(String.valueOf(value), (float) x, (float) y, textColor);
            canvas.drawRect(square,squarePaint);
        }




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
