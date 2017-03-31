package com.example.radik.worldoffractals;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Radik on 31.03.2017.
 */

public class SolutionCross {
    double a = 2.8, t, x, y, p;
    int   k, mx, my, rad, IterCross = 70000;
    private Paint paint;
    Canvas canvas;

    public void drawCross(DrawView drawView){
        paint = new Paint();
        canvas = new Canvas(drawView.bitmap);
        paint.setColor(Color.YELLOW);

        mx  = 450;
        my  = 450;
        x = 0.0;
        y = 0.0;
        for(k = 0; k < IterCross; k++)
        {
            p = (Math.random() * 101)/100.0;
            t = x;
            if(p <= 0.5){
                x = -y;
                y =  t;
            }
            else{
                x = 1 + (a * (x - 1))/((x - 1) * (x - 1) + y * y + 1);
                y = a * y/((t - 1) * (t - 1) + y * y + 1);
            }
            canvas.drawPoint((float)(mx + 450 * x),(float)(my - 450 * y), paint);
        }

    }
}
