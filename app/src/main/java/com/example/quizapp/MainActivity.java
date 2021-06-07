package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public String inputName(){
        EditText text=(EditText) findViewById(R.id.name);
        String name=text.getText().toString();
        return name;
    }
    public int marksCal(){
        int marks = 0;
        RadioGroup checker;
        checker = (RadioGroup) findViewById(R.id.rg1);
        int right = checker.getCheckedRadioButtonId();
        if (right == R.id.a1){
            marks = marks + 1;
            count += 1;
        }
        checker = (RadioGroup) findViewById(R.id.rg2);
        right = checker.getCheckedRadioButtonId();
        if(right == R.id.a2){
            marks = marks + 1;
            count += 1;
        }
        checker = (RadioGroup) findViewById(R.id.rg3);
        right = checker.getCheckedRadioButtonId();
        if(right == R.id.c3){
            marks = marks + 1;
            count += 1;
        }
        checker = (RadioGroup) findViewById(R.id.rg4);
        right = checker.getCheckedRadioButtonId();
        if(right == R.id.b4){
            marks = marks + 1;
            count += 1;
        }
        CheckBox check1 = (CheckBox) findViewById(R.id.a5);
        CheckBox check2 = (CheckBox) findViewById(R.id.c5);
        CheckBox check3 = (CheckBox) findViewById(R.id.b5);
        CheckBox check4 = (CheckBox) findViewById(R.id.d5);
        if(check3.isChecked() || check4.isChecked()){
            return marks;
        }
        else if(check1.isChecked() && check2.isChecked()){
            marks = marks + 1;
            count += 1;
        }
        return marks;
    }
    public void displayMarks(View view){
        int totalMarks = marksCal();
        TextView show = (TextView) findViewById(R.id.finalScore);
        TextView CAshow1 = (TextView) findViewById(R.id.correctAns1);
        TextView CAshow2 = (TextView) findViewById(R.id.correctAns2);
        TextView CAshow3 = (TextView) findViewById(R.id.correctAns3);
        TextView CAshow4 = (TextView) findViewById(R.id.correctAns4);
        TextView CAshow5 = (TextView) findViewById(R.id.correctAns5);
        String settext = "Name : " + inputName();
        settext += "\nMarks : " + totalMarks;
        settext += "\nNo. of correct answers : "+count;
        settext += "\nNo. of incorrect answers : "+(5 - count);
        show.setText(settext);
        CAshow1.setText("Correct Answer is \"Method\"");
        CAshow2.setText("Correct Answer is \"Id returns the identity of the object\"");
        CAshow3.setText("Correct Answer is \"Class\"");
        CAshow4.setText("Correct Answer is \"List\"");
        CAshow5.setText("Correct Answer is option(a) and option(c)");
        Toast.makeText(MainActivity.this,settext,Toast.LENGTH_SHORT).show();
    }
}