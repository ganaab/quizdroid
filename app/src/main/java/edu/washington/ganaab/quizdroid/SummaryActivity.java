package edu.washington.ganaab.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class SummaryActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        final Intent launchMe = getIntent();
        String topic = launchMe.getStringExtra("topic");
        String answer = launchMe.getStringExtra("answer");
        String answerC = launchMe.getStringExtra("answerC");
        String corrNum = launchMe.getStringExtra("correctCount");
        String qCount = launchMe.getStringExtra("countQ");

        TextView choice = (TextView) findViewById(R.id.textView5);
        TextView correct = (TextView) findViewById(R.id.textView6);
        TextView prog = (TextView) findViewById(R.id.textView7);
        Button nextQuestion = (Button) findViewById(R.id.button6);
        Button finisher = (Button) findViewById(R.id.button7);

        choice.setText(answer);
        correct.setText(answerC);
        prog.setText("You have answered " + corrNum + " out of " + qCount + " correctly.");

        if (qCount.equalsIgnoreCase("2")){
            nextQuestion.setVisibility(View.GONE);
            finisher.setVisibility(View.VISIBLE);
        } else {
            nextQuestion.setVisibility(View.VISIBLE);
            finisher.setVisibility(View.GONE);
        }

        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(SummaryActivity.this, QuestionActivity.class);
                String topic = launchMe.getStringExtra("topic");
                String correctCount = launchMe.getStringExtra("correctCount");
                if(topic.equalsIgnoreCase("math")){
                    String[] qa = {"What is 0 / 1 * 2 + 3 - 4?", "0", "1", "2", "-1", "-1"};
                    nextActivity.putExtra("questions", qa);
                } else if (topic.equalsIgnoreCase("physics")){
                    String[] qa = {"Name the device which converts electric energy into mechanical energy", "alternator", "transformer", "dynamo", "motor", "motor"};
                    nextActivity.putExtra("questions", qa);
                } else {
                    String[] qa = {"What color is Ironman's suit?", "Red", "Yellow", "Pink", "Green", "Red"};
                    nextActivity.putExtra("questions", qa);
                }
                nextActivity.putExtra("correctCount", correctCount);
                nextActivity.putExtra("countQ", "2");

                if (nextActivity.resolveActivity(getPackageManager()) != null) {
                    startActivity(nextActivity); // opens a new activity
                }
                // code still runs asynchronously

                finish(); // kill this instance self (this activity)
            }
        });
        finisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView fin = (TextView) findViewById(R.id.textView);
                TextView choice = (TextView) findViewById(R.id.textView5);
                TextView correct = (TextView) findViewById(R.id.textView6);
                TextView prog = (TextView) findViewById(R.id.textView7);
                Button nextQuestion = (Button) findViewById(R.id.button6);
                Button finisher = (Button) findViewById(R.id.button7);

                fin.setText("FINISHED");
                choice.setVisibility(View.GONE);
                correct.setVisibility(View.GONE);
                prog.setVisibility(View.GONE);
                nextQuestion.setVisibility(View.GONE);
                finisher.setVisibility(View.GONE);

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_summary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
