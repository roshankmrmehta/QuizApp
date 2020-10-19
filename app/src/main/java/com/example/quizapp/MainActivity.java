package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int marks;
    EditText editText;
    Button submit;
    CheckBox ans_brazil, ans_mexico, ans_colombia, ans_scotland;
    RadioButton ans_q3;
    RadioButton ans_q4;
    RadioButton ans_q5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.q1);
        ans_brazil = findViewById(R.id.ans_brazil);
        ans_mexico = findViewById(R.id.ans_mexico);
        ans_colombia = findViewById(R.id.ans_colombia);
        ans_scotland = findViewById(R.id.ans_scotland);
        ans_q3 = findViewById(R.id.q3_ans);
        ans_q4 = findViewById(R.id.q4_ans);
        ans_q5 = findViewById(R.id.q5_ans);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);

    }

    public void checkQuestFirst() {
        String answer = editText.getText().toString().trim();
        if (answer.equals("Sundar Pichai")) {
            marks += 1;
        }
        else{
            marks = marks -1;
        }
    }

    public void checkQuestSecond() {
        boolean isBrazil = ans_brazil.isChecked();
        boolean isMexico = ans_mexico.isChecked();
        boolean isColombia = ans_colombia.isChecked();
        boolean isScotland = ans_scotland.isChecked();

        if (isBrazil && isColombia && isMexico && !isScotland) {
            marks += 1;
        }
        else{
            marks = marks -1;
        }
    }

    public void checkQuestThird() {
        if (ans_q3.isChecked()) {
            marks += 1;
        }
        else{
            marks = marks -1;
        }
    }

    public void checkQuestFourth() {
        if (ans_q4.isChecked()) {
            marks += 1;
        }
        else{
            marks = marks -1;
        }
    }

    public void checkQuestFifth() {
        if (ans_q5.isChecked()) {
            marks += 1;
        }
        else{
            marks = marks -1;
        }
    }

    public void CollectAllQuestion() {
        checkQuestFirst();
        checkQuestSecond();
        checkQuestThird();
        checkQuestFourth();
        checkQuestFifth();
    }

    @Override
    public void onClick(View view) {
        CollectAllQuestion();
        Toast.makeText(this, "Score: " + marks + "/5", Toast.LENGTH_SHORT).show();
        submit.setEnabled(false);
    }
}