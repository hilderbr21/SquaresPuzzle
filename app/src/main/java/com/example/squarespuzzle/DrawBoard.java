package com.example.squarespuzzle;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class DrawBoard extends SurfaceView {

    public DrawBoard(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        setWillNotDraw(false);

    }

    @Override
    public void onDraw(Canvas canvas)
    {


    }

    private void drawSquare(Canvas canvas)
    {
        canvas.drawRect()
    }
}
