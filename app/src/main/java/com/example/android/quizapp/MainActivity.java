package com.example.android.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quizapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showResult(View view) {
        String finalScore = "";
        EditText name = (EditText) findViewById(R.id.name);
        String userName = name.getText().toString();
        if (userName.equalsIgnoreCase("")) {
            Toast toast = Toast.makeText(getApplicationContext(), R.string.hint, Toast.LENGTH_SHORT);
            TextView text = (TextView) toast.getView().findViewById(android.R.id.message);
            text.setTextSize(20);
            toast.show();
        } else {
            int score = calcScore();
            if (score == 5) {
                finalScore = name.getText().toString() + ",\n" + getResources().getString(R.string.full_score);
            } else {
                finalScore = name.getText().toString() + ",\n" + getResources().getString(R.string.score) + score + "/5";
            }
            Toast toast = Toast.makeText(getApplicationContext(), finalScore, Toast.LENGTH_SHORT);
            TextView text = (TextView) toast.getView().findViewById(android.R.id.message);
            text.setTextSize(30);
            toast.show();
        }
    }

    public int calcScore() {
        int score = 0;

        //QUESTION 1 (ANSWER IS "1903")
        EditText q1_text = (EditText) findViewById(R.id.q1_edit);
        String q1_ans = q1_text.getText().toString();
        if (q1_ans.equalsIgnoreCase("1903")) {
            score = score + 1;
        }

        //QUESTION 2 (ANSWER IS OPTION B, "1905")
        RadioButton q2_radio = (RadioButton) findViewById(R.id.q2_b);
        if (q2_radio.isChecked()) {
            score = score + 1;
        }

        //QUESTION 3 (ANSWER IS OPTION A AND B AND C; "BJK"&"FB"&"GS")
        CheckBox q3_a = (CheckBox) findViewById(R.id.q3_a);
        CheckBox q3_b = (CheckBox) findViewById(R.id.q3_b);
        CheckBox q3_c = (CheckBox) findViewById(R.id.q3_c);
        CheckBox q3_d = (CheckBox) findViewById(R.id.q3_d);
        if (q3_a.isChecked() && q3_b.isChecked() && q3_c.isChecked() && !q3_d.isChecked()) {
            score = score + 1;
        }

        //QUESTION 4 (ANSWER IS OPTION B, "4")
        RadioButton q4_radio = (RadioButton) findViewById(R.id.q4_b);
        if(q4_radio.isChecked()) {
            score = score + 1;
        }

        //QUESTION 5 (ANSWER IS "Galatasaray")
        EditText q5_text = (EditText) findViewById(R.id.q5_edit);
        String q5_ans = q5_text.getText().toString().trim();
        if (q5_ans.equalsIgnoreCase("Galatasaray")) {
            score = score + 1;
        }

        return score;
    }

    public void reset(View v) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
