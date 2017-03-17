package com.example.radik.worldoffractals;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Map;

/**
 * Created by Radik on 04.03.2017.
 */

public class SolutionNewton {
    int       i, j = 0, Iter, IterN = 25;
    double    x, y, Ak, Bk, Ak1, Bk1, z = 0.0, Rmin, dx, dy, x0, y0;
    boolean flag;
    Paint p = new Paint();
    Canvas canvas;

    public void drawNewton(DrawView drawView){
        Rmin = 1.0E-19;
        dx = 2.0/drawView.bitmap.getWidth();
        dy = 2.0/drawView.bitmap.getHeight();
        canvas = new Canvas(drawView.bitmap);

        for(i = 0, y0 = 1.0; i < drawView.bitmap.getWidth(); i++, y0 -= dy){
            x0 = -1.0;
            for(j = 0; j < drawView.bitmap.getHeight(); j++){
                x = x0; y = y0; Iter = 1;
                flag = true;
                while(flag){
                    Ak = 4 * x * x * x - 12 * x * y * y;
                    Bk = 4 * (3 * x * x * y - y * y * y);
                    x = 3 * x/4 + Ak/(Ak * Ak +  Bk * Bk);
                    y = 3 * y/4 - Bk/(Ak * Ak +  Bk * Bk);
                    if((Math.abs(x) > 2.0) || (Math.abs(y) > 2.0)){
                        p.setColor(Color.YELLOW);
                        canvas.drawPoint(i, j, p);
                        x0 += dx;
                        flag = false;
                    }
                    Ak1 = Math.pow(x, 4) + Math.pow(y, 4) - 6 * Math.pow(x, 2) * Math.pow(y, 2) - 1;
                    Bk1 = 4 * (Math.pow(x, 3) * y - x * Math.pow(y, 3));
                    Iter++;
                    z = Math.sqrt(Ak1 * Ak1 + Bk1 * Bk1);
                    if(Iter >= IterN){
                        p.setColor(Color.YELLOW);
                        canvas.drawPoint(i, j, p);
                        x0 += dx;
                        flag = false;
                    }
                    if(z < Rmin){
                        p.setColor(Color.BLUE);
                        canvas.drawPoint(i, j, p);
                        x0 += dx;
                        flag = false;
                    }
                }
                continue;
            }
        }

    }

}
