package com.gloria.lab3gloriaangelo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SubjectsTaken extends AppCompatActivity {
    CheckBox data1,data2,data3,data4,data5,data6,data7,data8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects_taken);

        data1 = findViewById(R.id.checkBox);
        data2 = findViewById(R.id.checkBox2);
        data3 = findViewById(R.id.checkBox3);
        data4 = findViewById(R.id.checkBox4);
        data5 = findViewById(R.id.checkBox5);
        data6 = findViewById(R.id.checkBox6);
        data7 = findViewById(R.id.checkBox7);
        data8 = findViewById(R.id.checkBox8);

        FileInputStream reader = null;
        String data = "";
        try {
            reader = openFileInput("data1.txt");
            int token;
            while((token = reader.read()) != -1){
                data = data + (char)token;
            }
        } catch (FileNotFoundException e) {
            Log.d("error","File note found...");
        } catch (IOException e) {
            Log.d("error","IO error...");
        }

        String toSplit[] = data.split(" ");
        data1.setText(toSplit[0]);
        data2.setText(toSplit[1]);
        data3.setText(toSplit[2]);
        data4.setText(toSplit[3]);
        data5.setText(toSplit[4]);
        data6.setText(toSplit[5]);
        data7.setText(toSplit[6]);
        data8.setText(toSplit[7]);
    }

    public void confirm(View v){
        String en = "Enrolled in: ";
        if(data1.isChecked()){
            en = en + " " + data1.getText().toString();
        }
        if(data2.isChecked()){
            en = en + " " + data2.getText().toString();
        }
        if(data3.isChecked()){
            en = en + " " + data3.getText().toString();
        }
        if(data4.isChecked()){
            en = en + " " + data4.getText().toString();
        }
        if(data5.isChecked()){
            en = en + " " + data5.getText().toString();
        }
        if(data6.isChecked()){
            en = en + " " + data6.getText().toString();
        }
        if(data7.isChecked()){
            en = en + " " + data7.getText().toString();
        }
        if(data8.isChecked()){
            en = en + " " + data8.getText().toString();
        }
        Toast.makeText(this,en,Toast.LENGTH_LONG).show();
    }
}
