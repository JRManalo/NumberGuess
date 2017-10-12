/**
 * Jeremy Manalo
 * 10-11-17
 * LandingActivity.java
 */

package com.example.jrman.NumberGuess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), GuessingActivity.class);
                startActivity(i);
            }
        });
    }
}
