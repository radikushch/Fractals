package com.example.radik.worldoffractals;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Radik on 04.03.2017.
 */

public class SolutionMandelbrot {
    int       i, j, Iter, IterM = 50;
    double    cx, cy, x, y, tx, ty, z, RminMore, Rmin, dx, dy, cxStart, cyStart;
    boolean flag = true;
    Paint p = new Paint();
    Canvas canvas;
    BuildManager b1 = new BuildManager();

    public void drawMandelbrot(DrawView drawView){
        Rmin     = 2.0;
        RminMore = 3.0;//2;
        dx       = RminMore/drawView.bitmap.getWidth();
        dy       = RminMore/drawView.bitmap.getHeight();
        cxStart  = -2.0; //-1.5;
        cyStart  = -1.5;//-1.0;
        canvas = new Canvas(drawView.bitmap);

        for(i = 0, cx = cxStart; i < drawView.bitmap.getWidth(); i++, cx += dx)
            for(j = 0, cy = cyStart; j < drawView.bitmap.getHeight(); j++, cy += dy) {
                x = cx;
                y = cy;
                Iter = 0;
                flag = true;
                while (flag) {
                    tx = x;
                    ty = y;
                    x = x * x - y * y + cx;
                    y = 2 * tx * ty + cy;
                    z = Math.sqrt(x * x + y * y);
                    Iter++;
                    if (Iter >= IterM) {
                        //col = color | IterM;
                        p.setColor(Color.YELLOW);
                        canvas.drawPoint(i, j, p);
                        flag = false;
                    }
                    if (z > Rmin) {
                        //col = color | Iter;
                        //p.setColor(Color.BLUE);
                        //canvas.drawPoint(i, j, p);
                        flag = false;
                    }
                }
                continue;
            }

    }


}
