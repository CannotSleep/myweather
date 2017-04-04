package com.happyday.z.testedittext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    class ttt  extends EditText{

        public ttt(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int px = getMeasuredWidth();

           int py = getMeasuredWidth();

            // Draw background

           //canvas.drawRect(0, 0, px, py, backgroundPaint);

           canvas.save();

            // 以画布中心为轴正向旋转90度

          canvas.rotate(90, px/2, py/2);
        }
    }

}
