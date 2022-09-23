package com.example.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button plusBtn;
    Button minusBtn;
    TextView outTv;
    int red = 255;
    int green = 255;
    int blue = 255;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        init();
        outTv.setText(String.valueOf(counter));
        outTv.setTextColor(Color.rgb(33, 150, 243));
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                setColor();
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                setColor();
            }
        });

        outTv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                counter = 0;
                setColor();
                return false;
            }
        });


    }

    public void setColor(){


        if (counter == 0){
            outTv.setTextColor(Color.BLUE);
        } else if (counter < 0) {
            outTv.setTextColor(Color.parseColor("#F44336"));
        } else {
            if (counter > 1){
                int count = 0;
                for (int i = 1; i <= Math.sqrt(counter); i++) {
                    if (counter % i == 0) {
                        count++;
                    }
                }

                if (count < 2){
                    outTv.setTextColor(Color.rgb(red, green, blue));
                } else {
                    outTv.setTextColor(Color.GREEN);
                }
            } else {
                outTv.setTextColor(Color.GREEN);
            }
        }
        outTv.setText(String.valueOf(counter));

    }


    public void init() {
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        outTv = findViewById(R.id.outputTv);
    }


}