package com.wrp.custom_drawables;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextPaint;
import android.view.View;

/**
 * Created by Girish on 22-04-2016.
 */
public class CustomDrawable extends View {
    private ShapeDrawable mDrawable;

    public CustomDrawable(Context context) {
        super(context);

        int x = 10;
        int y = 10;
        int width = 300;
        int height = 50;

        mDrawable = new ShapeDrawable(new OvalShape() );
        mDrawable.getPaint().setColor(0xff74AC23);
        mDrawable.setBounds(x, y, x + width, y + height);
    }

    @Override
    public boolean onCheckIsTextEditor() {
        return super.onCheckIsTextEditor();
    }

    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setTextSize(16);
        canvas.drawText("Girishramnani",100,100,p);
        mDrawable.draw(canvas);
    }
}