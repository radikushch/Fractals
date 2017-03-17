package com.example.radik.worldoffractals;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Radik on 04.03.2017.
 */

public class SolutionJulia {
    int       i, j, Iter, IterJ = 50;
    double    cx, cy, x, y, tx, ty, z, RminMore, Rmin, dx, dy, Julia = 0.36;
    boolean flag;
    Paint p = new Paint();
    Canvas canvas;

    public void drawJulia(DrawView drawView){
        Rmin     = 2.0;
        RminMore = 2.6;//2
        dx       = RminMore/drawView.bitmap.getWidth();
        dy       = RminMore/drawView.bitmap.getHeight();
        canvas = new Canvas(drawView.bitmap);

        for(i = 0, cx = -1.3; i < drawView.bitmap.getWidth(); i++, cx += dx)
            for(j = 0, cy = -1.3; j < drawView.bitmap.getHeight(); j++, cy += dy) {
                x = cx;
                y = cy;
                Iter = 0;
                flag = true;
                while (flag) {
                    tx = x;
                    ty = y;
                    x = x * x - y * y + Julia;
                    y = 2 * tx * ty + Julia;
                    z = Math.sqrt(x * x + y * y);
                    Iter++;
                    if (Iter >= IterJ) {
                        //col = color | IterM;
                        p.setColor(Color.YELLOW);
                        canvas.drawPoint(i, j, p);
                        flag = false;
                    }
                    if (z > Rmin) {
                        //col = color | Iter;
                        p.setColor(Color.BLUE);
                        canvas.drawPoint(i, j, p);
                        flag = false;

                    }
                }
                continue;
            }

    }


}
