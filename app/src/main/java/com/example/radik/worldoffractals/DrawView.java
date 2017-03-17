package com.example.radik.worldoffractals;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Radik on 04.03.2017.
 */

public class DrawView extends View {

    Bitmap bitmap;
    Paint paint;

    public DrawView(Context context) {
        super(context);
        bitmap = Bitmap.createBitmap(900, 900, Bitmap.Config.RGB_565 );
        bitmap.eraseColor(Color.rgb(255, 228, 196));
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(80, 80, 204,255);
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }
}
