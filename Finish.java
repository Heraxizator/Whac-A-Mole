package com.myapp.whac_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Finish extends AppCompatActivity {

    final String saved = "1";

    public void OpenBody() {
        Intent intent = new Intent(this, Body.class);
        startActivity(intent);
    }

    public void OpenMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        Button restart = findViewById(R.id.restart);
        Button menu = findViewById(R.id.menu);
        TextView score = findViewById(R.id.score2);
        TextView record = findViewById(R.id.record);

        Intent intent = getIntent();
        int result = intent.getIntExtra("score", 0);
        score.setText("Score: " + result);



        SharedPreferences spref = getPreferences(MODE_PRIVATE);
        record.setText("Record: " + saved);

        String num = spref.getString(saved, "1");
        if (result > Integer.parseInt(num)) {
            Editor editor = spref.edit();
            editor.putString(saved, "" + result);
            editor.apply();


        }


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenBody();
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenMain();
            }
        });
    }
}
