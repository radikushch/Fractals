package com.example.radik.worldoffractals;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


/**
 * Created by Radik on 04.03.2017.
 */

class SolutionTree {

    private Paint paint = new Paint();

    void drawTree(int x, int y, double a, int L, DrawView drawView){
        int x1, y1, p, s, i;
        double a1;
        Canvas canvas = new Canvas(drawView.bitmap);



        if(L < 8) return;
        x1 = (int) (x + L * Math.cos(a));
        y1 = (int) (y + L * Math.sin(a));
        if(L > 100) p = 100;
        else        p =   L;
        if(p < 40) {
            if ((Math.random() * 101) / 100.0 > 0.5) paint.setColor(Color.GREEN);
            else paint.setColor(Color.BLACK);
            for (i = 0; i < 4; i++) canvas.drawLine(x + i, y, x1, y1, paint);
        }
        else{
            paint.setColor(Color.argb(50, 150, 75, 0));
            for(i = 0; i < p/6; i++) canvas.drawLine(x1, y1, x + i - (p/12), y, paint);
        }
        for(i = 0; i < (9 - Math.random()*9); i++){
            s = (int)((Math.random())*(L - L/6)) + L/6;
            a1 = a + 1.6 * (0.5 - (Math.random()* 101)/100.0);
            x1 = (int) (x + s * Math.cos(a));
            y1 = (int) (y + s * Math.sin(a));
            drawTree(x1, y1, a1, (int) (p - 5 - (Math.random()*20)), drawView);

        }

    }

}
