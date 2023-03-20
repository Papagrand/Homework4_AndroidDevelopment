package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Table extends AppCompatActivity {
    String Login = "";
    String Password = "";
    EditText editText1, editText2;
    TextView textViewInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TableLayout tableLayout = new TableLayout( this);

        // первая строка
        TableRow tableRow1 = new TableRow(this);
        TextView textView1 = new TextView(this);
        textView1.setText("Логин/Email");
        textView1.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        tableRow1.addView(textView1, new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
        editText1 = new EditText(this);
        tableRow1.addView(editText1, new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
        // вторая строка
        TableRow tableRow2 = new TableRow(this);
        TextView textView2 = new TextView(this);
        textView2.setText("Пароль");
        textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        tableRow2.addView(textView2, new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
        editText2 = new EditText(this);
        editText2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        tableRow2.addView(editText2, new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT, 1.0f));


// добавляем кнопку
        Button buttonSave = new Button(this);
        buttonSave.setText("Сохранить");
        buttonSave.setWidth(200); // задаем ширину кнопки в пикселях
        buttonSave.setHeight(100); // задаем высоту кнопки в пикселях
        buttonSave.setOnClickListener(onClickListenerSave);

        // новая строка с кнопкой
        TableRow tableRow3 = new TableRow(this);
        tableRow3.addView(buttonSave);

        Button buttonBack = new Button(this);
        buttonBack.setText("Linear");
        buttonBack.setTextSize(18);
        buttonBack.setOnClickListener(onClickListenerBack);
        buttonBack.setWidth(200);
        buttonBack.setHeight(100);
        TableRow tableRowBack = new TableRow(this);
        TableRow.LayoutParams buttonParams = new TableRow.LayoutParams();
        buttonParams.gravity = Gravity.BOTTOM;
        buttonBack.setLayoutParams(buttonParams);
        tableRowBack.addView(buttonBack);


// Текствью ниже
        textViewInfo = new TextView(this);
        textViewInfo.setText("Логин и пароль"+"\nзапишутся сюда");
        textViewInfo.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        textViewInfo.setBackgroundColor(Color.parseColor("#FFB02E"));
        TableRow tableRow4 = new TableRow(this);
        tableRow4.addView(textViewInfo, new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        tableLayout.addView(tableRow1);
        tableLayout.addView(tableRow2);
        tableLayout.addView(tableRow3);
        tableLayout.addView(tableRow4);
        tableLayout.addView(tableRowBack);

        setContentView(tableLayout);


    }
    View.OnClickListener onClickListenerSave = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Login+=editText1.getText().toString();
            Password+=editText2.getText().toString();
            textViewInfo.setText("Логин/Email: "+Login+"\nПароль: "+Password);
            editText1.setText("");
            editText2.setText("");
        }
    };

    View.OnClickListener onClickListenerBack = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onBackPressed();
        }
    };
}