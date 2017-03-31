package com.example.radik.worldoffractals;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Radik on 31.03.2017.
 */

public class SolutionSTARSC {

    private Paint paint;
    private Canvas canvas;

    public void drawSTARSC(DrawView drawView){
        int   Iter1 = 0, nx, ny, IterSTARSC = 100000;
        double x1, y1, sx, sy, sx4, sy4;

        double aSTARSC = 2 * (0.5 - (Math.random() * 101)/100.0);
        double bSTARSC = 2 * (0.5 - (Math.random() * 101)/100.0);
        double cSTARSC = 2 * (0.5 - (Math.random() * 101)/100.0);
        double dSTARSC = 2 * (0.5 - (Math.random() * 101)/100.0);
        double xSTARSC = (Math.random() * 101)/100.0;
        double ySTARSC = (Math.random() * 101)/100.0;

        paint = new Paint();
        paint.setColor(Color.YELLOW);
        canvas = new Canvas(drawView.bitmap);
        canvas = new Canvas(drawView.bitmap);

        for(Iter1 = 0; Iter1 < IterSTARSC; Iter1++)
        {
            sx  = Math.PI * 2 * xSTARSC;
            sy  = Math.PI * 2 * ySTARSC;
            sx4 = Math.PI * 4 * xSTARSC;
            sy4 = Math.PI * 4 * ySTARSC;
            x1  = aSTARSC * Math.sin(sx) + bSTARSC * Math.sin(sx) * Math.sin(sy) + cSTARSC *
                    Math.sin(sx4) + dSTARSC * Math.sin(Math.PI * 6 * xSTARSC) * Math.cos(sy4);
            y1  = aSTARSC * Math.sin(sy) + bSTARSC * Math.sin(sy) * Math.cos(sx) + cSTARSC *
                    Math.sin(sy4) + dSTARSC * Math.sin(Math.PI * 6 * ySTARSC) * Math.cos(sx4);
            nx  = (int)(200 * x1 + 450); ny  = (int)(200 * y1 + 420);
            canvas.drawPoint(nx, ny, paint);
            xSTARSC = x1;
            ySTARSC = y1;
        }
    }
}
