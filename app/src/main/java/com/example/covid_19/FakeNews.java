package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FakeNews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_news);

        getSupportActionBar().hide();

    }

    public void clicouVoltar(View v){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

}
