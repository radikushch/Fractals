package com.example.radik.worldoffractals;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Radik on 28.03.2017.
 */

public class SolutionStar {
    int   i, c, IterStar = 3;
    double x, y, x1, y1;
    double a[] = new double[100];
    double b[] = new double[100];
    Paint p;
    Canvas canvas;


    void drawStar(DrawView drawView){
        p = new Paint();
        canvas = new Canvas(drawView.bitmap);
        p.setColor(Color.YELLOW);

        x = 1; y = 1;
        for(i = 0; i < IterStar; i++)
        {
            a[2 * i]     = Math.cos(2 * Math.PI * (i + 1)/IterStar);
            b[2 * i]     = Math.sin(2 * Math.PI * (i + 1)/IterStar);
            a[2 * i + 1] = 0.5 * (Math.cos(2 * Math.PI * (i + 1)/IterStar) +
                    Math.cos(2 * Math.PI * i/IterStar));
            b[2 * i + 1] = 0.5 * (Math.sin(2 * Math.PI * (i + 1)/IterStar) +
                    Math.sin(2 * Math.PI * i/IterStar));
        }
        for(i = 0; i < 100000; i++)
        {
            c  = (int)(Math.random() * (2 * IterStar));
            x1 =  (x/(x * x + y * y))/3 + a[c]; y1 = (-y/(x * x + y * y))/3 + b[c];
            x  = x1/(x1 * x1 + y1 * y1);        y  = y1/(x1 * x1 + y1 * y1);
            canvas.drawPoint((float)(100 * x + 350), (float)(100 * y + 400), p);
        }
    }
}
