package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Linear extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button buttonEnter, buttonClear;
    private String allText="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(10,10,10,10);
        linearLayout.setWeightSum(4);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0, 2);
        layoutParams.gravity = Gravity.CENTER;
//Верхний editText
        editText = new EditText(this);
        editText.setLayoutParams(layoutParams);
        editText.setHint("Введите сообщение");
        editText.setGravity(Gravity.TOP);
        linearLayout.addView(editText);
        layoutParams.weight = 1;
//TextView
        textView = new TextView(this);
        textView.setText("Пустое сообщение");
        textView.setBackgroundColor(Color.parseColor("#D3CAA5"));
        textView.setTextSize(18);
        layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
//Создание кнопок Ввести и Очистить
        LinearLayout buttonEnterClearLayout = new LinearLayout(this);
        buttonEnterClearLayout.setOrientation(LinearLayout.HORIZONTAL);
        buttonEnterClearLayout.setGravity(Gravity.CENTER);
        buttonEnterClearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        LinearLayout.LayoutParams buttonEnterParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        buttonEnterParams.gravity = Gravity.CENTER;

        buttonEnter = new Button(this);
        buttonEnter.setText("Ввести");
        buttonEnter.setBackgroundColor(Color.parseColor("#FFB02E"));
        buttonEnterParams.setMargins(0,40,20,10);
        buttonEnter.setTextSize(18);
        buttonEnter.setLayoutParams(buttonEnterParams);
        buttonEnter.setOnClickListener(onClickListenerEnter);
        buttonEnterClearLayout.addView(buttonEnter);

        buttonClear = new Button(this);
        buttonClear.setText("Очистить");
        buttonClear.setBackgroundColor(Color.parseColor("#FFB02E"));
        buttonEnterParams.setMargins(20,40,10,10);
        buttonClear.setTextSize(18);
        buttonClear.setLayoutParams(buttonEnterParams);
        buttonClear.setOnClickListener(onClickListenerClear);
        buttonEnterClearLayout.addView(buttonClear);

        linearLayout.addView(buttonEnterClearLayout);
//Конец
//Создание кнопок для перемещения
        LinearLayout linearLayoutWithButtons = new LinearLayout(this);
        linearLayoutWithButtons.setOrientation(LinearLayout.HORIZONTAL);
        linearLayoutWithButtons.setGravity(Gravity.BOTTOM);
        linearLayoutWithButtons.setGravity(Gravity.CENTER_HORIZONTAL);
        Button goToRelativeLayout = new Button(this);
        Button goToTableLayout = new Button(this);
        Button goToFrameLayout = new Button(this);
        Button goToGridLayout = new Button(this);

        goToRelativeLayout.setId(1);
        goToTableLayout.setId(2);
        goToFrameLayout.setId(3);
        goToGridLayout.setId(4);

        goToRelativeLayout.setText("Relative");
        goToTableLayout.setText("Table");
        goToFrameLayout.setText("Frame");
        goToGridLayout.setText("Grid");

        goToRelativeLayout.setOnClickListener(this::BarButton1);
        goToTableLayout.setOnClickListener(this::BarButton1);
        goToFrameLayout.setOnClickListener(this::BarButton1);
        goToGridLayout.setOnClickListener(this::BarButton1);

        linearLayoutWithButtons.addView(goToRelativeLayout);
        linearLayoutWithButtons.addView(goToTableLayout);
        linearLayoutWithButtons.addView(goToFrameLayout);
        linearLayoutWithButtons.addView(goToGridLayout);

        linearLayout.addView(linearLayoutWithButtons);
        setContentView(linearLayout);
    }
    public void BarButton1(View view){
        Intent intent;
        switch (view.getId()){
            case 1: {
                intent = new Intent(this, Relative.class);
                startActivity(intent);
                break;
            }
            case 2: {
                intent = new Intent(this, Table.class);
                startActivity(intent);
                break;
            }
            case 3: {
                intent = new Intent(this, Frame.class);
                startActivity(intent);
                break;
            }
            case 4: {
                intent = new Intent(this, Grid.class);
                startActivity(intent);
                break;
            }
        }
    }
    View.OnClickListener onClickListenerEnter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            allText+=editText.getText().toString();
            allText+='\n';
            textView.setText(allText);
            editText.setText("");
        }
    };
    View.OnClickListener onClickListenerClear = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            allText="";
            textView.setText("Пустое сообщение");
            editText.setText("");
        }
    };
}