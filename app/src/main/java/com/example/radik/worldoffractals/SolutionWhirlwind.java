package com.example.radik.worldoffractals;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Radik on 11.03.2017.
 */

public class SolutionWhirlwind {
    private int   k, q, mx, my, rad;
    private double x, y, p, c0, s0, tmp;
    double []c = new double[12];
    double []s = new double[12];
    private Canvas canvas = new Canvas();
    private Paint paint = new Paint();

    public void drawWhirlwind(DrawView drawView){
        mx = drawView.bitmap.getWidth()/2;
        my = drawView.bitmap.getHeight()/2;
        rad = (int) (0.8 * my);
        c0 = Math.cos(-0.05 * Math.PI);
        s0 = Math.sin(-0.05 * Math.PI);
        for(k = 0; k < 12; k++){
            c[k] = Math.cos(2.0 * k * Math.PI/12);
            s[k] = Math.sin(2.0 * k * Math.PI/12);
        }
        x = 0.0;
        y = 0.0;
        for(k = 0; k < 50000; k++){
            p = (Math.random() * 101)/ 100.0;
            q = (int) (Math.random() * 12);
            if(p < 0.25) {
                tmp = x;
                x = BWhirlwindx(c[q], s[q], x, y);
                y = BWhirlwindy(c[q], s[q], tmp, y);
            }
            else {
                tmp = x;
                x = Awhirlwindx(c0, s0, x, y);
                y = Awhirlwindy(c0, s0, tmp, y);
            }

            paint.setColor(Color.YELLOW);
            canvas.drawPoint((float) (mx + x * rad), (float) (my + y * rad), paint);
        }
    }

    private double Awhirlwindx(double c0, double s0, double x, double y){
        double r = 0.75, t;
        t = x;
        x = r * (c0 * x + s0 * y);
        return x;
    }

    private double Awhirlwindy(double c0, double s0, double x, double y){
        double r = 0.75, t;
        t = x;
        y = r * (-s0 * t + c0 * y);
        return y;
    }

    private double BWhirlwindx(double c0, double s0, double x, double y){
        double r = 0.14;
        x = r * x + c0;
        return x;
    }

    private double BWhirlwindy(double c0, double s0, double x, double y){
        double r = 0.14;
        y = r * y + s0;
        return y;
    }



}
