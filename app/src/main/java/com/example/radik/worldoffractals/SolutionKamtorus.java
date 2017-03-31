package com.example.radik.worldoffractals;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.YuvImage;
import android.graphics.drawable.Drawable;

/**
 * Created by Radik on 31.03.2017.
 */

public class SolutionKamtorus {
    private double x, t, y, x0, a;
    private int   i, IterKamtorus = 10000;
    Paint p;
    Canvas canvas;

    public void drawKamtorus(DrawView drawView){
        p = new Paint();
        canvas = new Canvas(drawView.bitmap);
        p.setColor(Color.YELLOW);

        x = y = x0 = 0;
        do
        {
            y = 0; x = x0;
            for(i = 0; i < IterKamtorus; i++)
            {
                a = 2; t = x;
                x = x * Math.cos(a) - (y - x * x) * Math.sin(a); y = t * Math.sin(a) + (y - t * t) * Math.cos(a);
                canvas.drawPoint((float)(x * 300 + 350), (float)(y * 300 + 300), p);
                if((x > 10) || (y > 10)) break;
            }
            x0 = x0 + 0.01;
        }
        while(x0 < 1);

    }
}
