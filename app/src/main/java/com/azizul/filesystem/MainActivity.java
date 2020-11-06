package com.azizul.filesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPreferences= getSharedPreferences(  "myfile", Context.MODE_PRIVATE);

        findViewById(R.id.btnSave).setOnClickListener((View v) -> {
            String fName = ((EditText) findViewById(R.id.FirstName)).getText().toString();
            String LName = ((EditText) findViewById(R.id.LastName)).getText().toString();
            SharedPreferences.Editor Editor = mPreferences.edit();
            Editor.putString("fNamekey",fName);
            Editor.putString("LNamekey",LName);
            Editor.apply();
        });


        findViewById(R.id.button2).setOnClickListener((View v) ->{
            ((EditText) findViewById(R.id.FirstName)).setText(mPreferences.getString("fNamekey","N/A"));
            ((EditText) findViewById(R.id.LastName)).setText(mPreferences.getString("LNamekey","N/A"));
        });
    }
}