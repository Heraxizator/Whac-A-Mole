package com.myapp.whac_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Body extends AppCompatActivity {
    public int k = 0;

    public void display(Button aim1, Button aim2, Button aim3, Button aim4, Button aim5, Button aim6, Button aim7, Button aim8, Button aim9) {
        aim1.setVisibility(View.INVISIBLE);
        aim2.setVisibility(View.INVISIBLE);
        aim3.setVisibility(View.INVISIBLE);
        aim4.setVisibility(View.INVISIBLE);
        aim5.setVisibility(View.INVISIBLE);
        aim6.setVisibility(View.INVISIBLE);
        aim7.setVisibility(View.INVISIBLE);
        aim8.setVisibility(View.INVISIBLE);
        aim9.setVisibility(View.INVISIBLE);

    }


    public void event(Button aim, double h) {
        if (Math.random() < h) {
            aim.setVisibility(View.VISIBLE);
        }
    }

    public void OpenEnd(int k) {
        Intent intent = new Intent(this, Finish.class);
        intent.putExtra("score", k);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        Button aim1 = findViewById(R.id.aim1);
        Button aim2 = findViewById(R.id.aim2);
        Button aim3 = findViewById(R.id.aim3);
        Button aim4 = findViewById(R.id.aim4);
        Button aim5 = findViewById(R.id.aim5);
        Button aim6 = findViewById(R.id.aim6);
        Button aim7 = findViewById(R.id.aim7);
        Button aim8 = findViewById(R.id.aim8);
        Button aim9 = findViewById(R.id.aim9);

        TextView score = findViewById(R.id.score);
        TextView timer = findViewById(R.id.timer);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.aim1:
                        if (aim1.getVisibility() == View.VISIBLE) {
                            k++;
                        }
                        break;
                    case R.id.aim2:
                        if (aim2.getVisibility() == View.VISIBLE) {
                            k++;
                        }
                        break;
                    case R.id.aim3:
                        if (aim3.getVisibility() == View.VISIBLE) {
                            k++;
                        }
                        break;
                    case R.id.aim4:
                        if (aim4.getVisibility() == View.VISIBLE) {
                            k++;
                        }
                        break;
                    case R.id.aim5:
                        if (aim5.getVisibility() == View.VISIBLE) {
                            k++;
                        }
                        break;
                    case R.id.aim6:
                        if (aim6.getVisibility() == View.VISIBLE) {
                            k++;
                        }
                        break;
                    case R.id.aim7:
                        if (aim7.getVisibility() == View.VISIBLE) {
                            k++;
                        }
                        break;
                    case R.id.aim8:
                        if (aim8.getVisibility() == View.VISIBLE) {
                            k++;
                        }
                        break;
                    case R.id.aim9:
                        if (aim9.getVisibility() == View.VISIBLE) {
                            k++;
                        }
                        break;
                }

            }
        };

        aim1.setOnClickListener(onClickListener);
        aim2.setOnClickListener(onClickListener);
        aim3.setOnClickListener(onClickListener);
        aim4.setOnClickListener(onClickListener);
        aim5.setOnClickListener(onClickListener);
        aim6.setOnClickListener(onClickListener);
        aim7.setOnClickListener(onClickListener);
        aim8.setOnClickListener(onClickListener);
        aim9.setOnClickListener(onClickListener);



        CountDownTimer countDownTimer = new CountDownTimer(30 * 1000, 500) {
            float c = 30;
            double h = 0.1;

            @Override
            public void onTick(long l) {
                c -= 0.5;
                timer.setText("Timer: " + c);
                score.setText("Score: " + k);
                display(aim1, aim2, aim3, aim4, aim5, aim6, aim7, aim8, aim9);
                event(aim1, h);
                event(aim2, h);
                event(aim3, h);
                event(aim4, h);
                event(aim5, h);
                event(aim6, h);
                event(aim7, h);
                event(aim8, h);
                event(aim9, h);
            }

            @Override
            public void onFinish() {
                OpenEnd(k);

            }
        }.start();




    }
}
