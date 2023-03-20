package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class Relative extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setPadding(20,20,20,20);
        TextView textView1 = new TextView(this);
        textView1.setText("Левый верх");
        textView1.setId(R.id.LeftUp);
        textView1.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        String randomColour=getRandomColorHex();
        textView1.setBackgroundColor(Color.parseColor(randomColour));
        textView1.setTextColor(Color.parseColor(getContrastColor(randomColour)));

        TextView textView2 = new TextView(this);
        textView2.setId(R.id.RightUp);
        textView2.setText("Правый верх");
        textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        randomColour=getRandomColorHex();
        textView2.setBackgroundColor(Color.parseColor(randomColour));
        textView2.setTextColor(Color.parseColor(getContrastColor(randomColour)));

        TextView textView3 = new TextView(this);
        textView1.setId(R.id.LeftBot);
        textView3.setText("Левый низ");
        textView3.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        randomColour=getRandomColorHex();
        textView3.setBackgroundColor(Color.parseColor(randomColour));
        textView3.setTextColor(Color.parseColor(getContrastColor(randomColour)));

        TextView textView4 = new TextView(this);
        textView1.setId(R.id.RightBot);
        textView4.setText("Правый низ");
        textView4.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        randomColour=getRandomColorHex();
        textView4.setBackgroundColor(Color.parseColor(randomColour));
        textView4.setTextColor(Color.parseColor(getContrastColor(randomColour)));

        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        relativeLayout.addView(textView1, layoutParams1);

        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        layoutParams2.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        relativeLayout.addView(textView2, layoutParams2);

        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams3.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        relativeLayout.addView(textView3, layoutParams3);

        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams4.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        layoutParams4.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        relativeLayout.addView(textView4, layoutParams4);

//Создание кнопок Назад и Изменить цвет
        Button buttonBack = new Button(this);
        buttonBack.setText("Linear");
        buttonBack.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        buttonBack.setOnClickListener(onClickListenerBack);

        Button buttonChangeColour = new Button(this);
        buttonChangeColour.setText("Изменить цвет");
        buttonChangeColour.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        buttonChangeColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String randomColour=getRandomColorHex();
                textView1.setBackgroundColor(Color.parseColor(randomColour));
                textView1.setTextColor(Color.parseColor(getContrastColor(randomColour)));

                randomColour=getRandomColorHex();
                textView2.setBackgroundColor(Color.parseColor(randomColour));
                textView2.setTextColor(Color.parseColor(getContrastColor(randomColour)));

                randomColour=getRandomColorHex();
                textView3.setBackgroundColor(Color.parseColor(randomColour));
                textView3.setTextColor(Color.parseColor(getContrastColor(randomColour)));

                randomColour=getRandomColorHex();
                textView4.setBackgroundColor(Color.parseColor(randomColour));
                textView4.setTextColor(Color.parseColor(getContrastColor(randomColour)));

            }
        });

        RelativeLayout.LayoutParams bottomBackParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bottomBackParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        bottomBackParams.addRule(RelativeLayout.CENTER_VERTICAL);
        bottomBackParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        bottomBackParams.addRule(RelativeLayout.LEFT_OF,buttonChangeColour.getId());
        relativeLayout.addView(buttonBack, bottomBackParams);



        RelativeLayout.LayoutParams bottomChangeColourParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bottomChangeColourParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        bottomChangeColourParams.addRule(RelativeLayout.CENTER_VERTICAL);
        bottomChangeColourParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        bottomChangeColourParams.addRule(RelativeLayout.RIGHT_OF,buttonBack.getId());
        relativeLayout.addView(buttonChangeColour, bottomChangeColourParams);

        setContentView(relativeLayout);
    }
    public static String getRandomColorHex() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        int color = Color.rgb(red, green, blue);
        return String.format("#%06X", (0xFFFFFF & color));
    }
    public static String getContrastColor(String colorHash) {
        int color = Color.parseColor(colorHash);
        double darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255;
        if (darkness < 0.5) {
            return "#FFFFFF"; // возвращаем белый цвет в виде хешкода
        } else {
            return "#000000"; // возвращаем черный цвет в виде хешкода
        }
    }

    View.OnClickListener onClickListenerBack = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onBackPressed();
        }
    };
}