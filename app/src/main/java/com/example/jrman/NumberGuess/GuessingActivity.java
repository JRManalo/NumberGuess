/**
 * Jeremy Manalo
 * 10-11-17
 * GuessingActivity.java
 */

package com.example.jrman.NumberGuess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuessingActivity extends AppCompatActivity {
    public static String intentTag = "inputData";

    int upperLimit = 20;
    int lowerLimit = 1;
    int guessesCounter;

    int targetNumber = (int)(Math.random() * upperLimit) + lowerLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);

//        if(getIntent().hasExtra(LandingActivity.intentTag)){
//            String message = getIntent().getStringExtra(LandingActivity.intentTag);
//
//            Toast.makeText(getApplicationContext(), "Hi", Toast.LENGTH_SHORT).show();
//        }

        Button check = (Button) findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                EditText inputData = (EditText) findViewById(R.id.number);
                String inputString = inputData.getText().toString();

                Log.d("Debug", "Random number is: " + String.valueOf(targetNumber));

                if(inputString.isEmpty())
                {
                    Toast.makeText(GuessingActivity.this, "Field cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int inputInt = Integer.parseInt(inputString);

                    if(targetNumber > inputInt)
                    {
                        guessesCounter ++;
                        Toast.makeText(GuessingActivity.this, "The number is higher",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if(targetNumber < inputInt)
                    {
                        guessesCounter ++;
                        Toast.makeText(GuessingActivity.this, "The number is lower",
                                Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        guessesCounter ++;
//                        Toast.makeText(GuessingActivity.this,
//                                "You got it in " + guessesCounter + "!",
//                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                        intent.putExtra(intentTag, String.valueOf(guessesCounter));
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }
}
