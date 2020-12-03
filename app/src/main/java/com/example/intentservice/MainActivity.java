package com.example.intentservice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.inputIntent);

    }

    public void beginService (View v){

        String intentSerivceText = input.getText().toString();

        Intent intent = new Intent(this , IntentServices.class);
        intent.putExtra("body" , intentSerivceText);

        ContextCompat.startForegroundService(this , intent);
    }
}