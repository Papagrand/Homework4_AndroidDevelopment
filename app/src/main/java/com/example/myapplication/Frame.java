package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Frame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout = new FrameLayout(this);


        TextView textView = new TextView(this);
        textView.setText("ScrollView с картинками");
        FrameLayout.LayoutParams layoutParams = new
                FrameLayout.LayoutParams
                (FrameLayout.LayoutParams.WRAP_CONTENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.TOP;
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(26);
        frameLayout.addView(textView);

        ScrollView scrollView = new ScrollView(this);
        FrameLayout.LayoutParams scrollParams = new FrameLayout.LayoutParams(256, 256);
        scrollParams.gravity = Gravity.CENTER;
        scrollView.setLayoutParams(scrollParams);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);

// создание картинок
        ImageView imageView1 = new ImageView(this);
        imageView1.setImageResource(R.drawable.image1);
        linearLayout.addView(imageView1);

        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.drawable.image2);
        linearLayout.addView(imageView2);

        ImageView imageView3 = new ImageView(this);
        imageView3.setImageResource(R.drawable.image3);
        linearLayout.addView(imageView3);

        scrollView.addView(linearLayout);
        frameLayout.addView(scrollView);

//Создание кнопки назад

        Button buttonBack = new Button(this);
        buttonBack.setText("Linear");
        buttonBack.setTextSize(18);
        buttonBack.setOnClickListener(onClickListenerBack);
        FrameLayout.LayoutParams buttonParams = new FrameLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonParams.gravity = Gravity.BOTTOM;
        buttonBack.setLayoutParams(buttonParams);
        frameLayout.addView(buttonBack);

        setContentView(frameLayout);
    }


    View.OnClickListener onClickListenerBack = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onBackPressed();
        }
    };

}