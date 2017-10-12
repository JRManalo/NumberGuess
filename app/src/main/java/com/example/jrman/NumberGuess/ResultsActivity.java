/**
 * Jeremy Manalo
 * 10-11-17
 * ResultsActivity.java
 */

package com.example.jrman.NumberGuess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity
{
    TextView answer;
    Button playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        locateViews();

        bindFunctionality();

        if (getIntent().hasExtra(GuessingActivity.intentTag))
        {
            String guesses = getIntent().getStringExtra(GuessingActivity.intentTag);

            //Toast.makeText(getApplicationContext(), guesses, Toast.LENGTH_SHORT).show();
        }
    }

    private void locateViews()
    {
        answer = (TextView) findViewById((R.id.answer));
        playAgain = (Button) findViewById(R.id.playAgain);
    }

    private void bindFunctionality()
    {
        answer.setText(getIntent().getStringExtra(GuessingActivity.intentTag));

        playAgain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getApplicationContext(), LandingActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}
