package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;

public class Grid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GridLayout gridLayout = new GridLayout( this);
        // количество строк
        gridLayout.setRowCount(3);
        // количество столбцов
        gridLayout.setColumnCount(3);
        for(int i = 1; i <=9; i++){
            Button btn = new Button(this);
            btn.setText(String.valueOf(i));
            gridLayout.addView(btn);
        }
        setContentView(gridLayout);
    }
}