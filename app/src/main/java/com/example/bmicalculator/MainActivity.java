package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextWeight = findViewById(R.id.weight);
        EditText editTextHeight = findViewById(R.id.height);
        Button button = findViewById(R.id.btnSubmit);
        TextView textView = findViewById(R.id.result);
        CardView card = findViewById(R.id.status);

        button.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                float height = Float.parseFloat(String.valueOf(editTextHeight.getText())) / 100;
                float weight = Float.parseFloat(String.valueOf(editTextWeight.getText()));
                float bmi = weight / (height * height);
                textView.setText(String.valueOf(bmi));

                if (bmi > 24) {
                    textView.setText("Over Weight: " + bmi);
                    card.setCardBackgroundColor(Color.parseColor("#FFA500"));
                } else if (bmi>18) {
                    textView.setText("Normal Weight :"+bmi);
                    card.setCardBackgroundColor(Color.parseColor("#19B81F"));
                }
                else {
                    textView.setText("Under Weight :"+bmi);
                    card.setCardBackgroundColor(Color.parseColor("#ff0000"));
                }
            }
        });
    }
}