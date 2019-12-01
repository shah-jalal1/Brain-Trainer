package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class SubActivity extends AppCompatActivity {

    public Button goButton;
    public TextView resultText;
    public TextView pointTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timeTextView;
    Button playAgainButton;
    RelativeLayout relativeLayout;

    ArrayList<Integer> answer = new ArrayList<Integer>();
    int locationCorrectAnswer;
    int locationIncorrectAnswer;
    int score=0;
    int numberOfQuestion = 0;

    // If you want to play after time finished
    public void playAgain(View view)
    {

        generateQuestion();

        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);

        playAgainButton.setVisibility(View.INVISIBLE);
        timeTextView.setText("0s");
        pointTextView.setText("0/0");
        resultText.setText("");

        //add time for quiz
        new CountDownTimer(30100, 1000)
        {


            @Override
            public void onTick(long l) {

                timeTextView.setText(String.valueOf(l/1000 + "s"));

            }

            @Override
            public void onFinish() {

                playAgainButton.setVisibility(View.VISIBLE);
                timeTextView.setText("0s");
                resultText.setText("Your score " +Integer.toString(score) + "/" + Integer.toString(numberOfQuestion));
                button0.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);

            }
        }.start();

    }

    //Question generate into the 4 button
    public void generateQuestion()
    {


        Random random = new Random();

        int a = random.nextInt(21);
        int b = random.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " - " + Integer.toString(b));
        locationCorrectAnswer = random.nextInt(4);

        answer.clear();

        for (int i=0; i<4; i++) {
            if (i == locationCorrectAnswer) {

                answer.add(a - b);

            }

            else {

                locationIncorrectAnswer = random.nextInt(41);
                while (locationIncorrectAnswer == a-b) {

                    locationIncorrectAnswer = random.nextInt(41);

                }
                answer.add(locationIncorrectAnswer);

            }
        }

        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));

    }

    //go button
    public void start(View view)
    {
        goButton.setVisibility(view.INVISIBLE);
        relativeLayout.setVisibility(View.VISIBLE);

        playAgain(findViewById(R.id.plaAgainButtonId));

    }

    // set the answer
    public void chooseAnswer(View view)
    {
        if (view.getTag().toString().equals(Integer.toString(locationCorrectAnswer))) {

            score++;
            resultText.setText("correct!");

        }

        else {
            resultText.setText("wrong!");
        }

        numberOfQuestion++;

        pointTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestion));
        generateQuestion();

    }

    //onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        goButton = (Button) findViewById(R.id.goButtonId);
        resultText = (TextView) findViewById(R.id.resultTextViewId);

        sumTextView = (TextView) findViewById(R.id.sumTextViewId);
        pointTextView = (TextView) findViewById(R.id.pointTextViewId);

        button0 = (Button) findViewById(R.id.button0Id);
        button1 = (Button) findViewById(R.id.button1Id);
        button2 = (Button) findViewById(R.id.button2Id);
        button3 = (Button) findViewById(R.id.button3Id);
        timeTextView = (TextView) findViewById(R.id.timeTextViewId);
        playAgainButton = (Button) findViewById(R.id.plaAgainButtonId);
        relativeLayout = (RelativeLayout) findViewById(R.id.gameRelativeLayoutId);


    }

}
