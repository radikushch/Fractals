package com.example.radik.worldoffractals;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Radik on 28.03.2017.
 */

public class SoulutionChip {
    double x, t, y, a, b, c;
    int   Iter, X, Y, IterChip;
    Paint p;
    Canvas canvas;

    void drawChip(DrawView drawView){
        x =   1;
        y =   1;
        a = -15;
        b = -19;
        c = (float) 1.0;
        IterChip = 1000000;
        p = new Paint();
        canvas = new Canvas(drawView.bitmap);

        for(Iter = 0; Iter < IterChip; Iter++)
        {
            t = x;
            x = y - x * Math.cos(Math.sqrt(Math.abs(Math.log(Math.abs(b * x - c)))))/Math.abs(x);
            y = a - t;
            X = (int)(x * 13);
            Y = (int)(y * 13);
            p.setColor(Color.YELLOW);
            canvas.drawPoint(X + 550, Y + 550, p);
        }
    }
}
