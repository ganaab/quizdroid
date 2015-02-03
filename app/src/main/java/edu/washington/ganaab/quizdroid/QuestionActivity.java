package edu.washington.ganaab.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class QuestionActivity extends ActionBarActivity {

    private int choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        RadioButton one = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton two = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton three = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton four = (RadioButton) findViewById(R.id.radioButton4);
        Button nextQuestion = (Button) findViewById(R.id.button5);


        Intent launchMe = getIntent();
        String[] qa = launchMe.getStringArrayExtra("questions");

        TextView question = (TextView) findViewById(R.id.textView2);
        question.setText(qa[0]);
        one.setText(qa[1]);
        two.setText(qa[2]);
        three.setText(qa[3]);
        four.setText(qa[4]);


        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchMe = getIntent();
                String topic = launchMe.getStringExtra("topic");
                String[] qa2 = launchMe.getStringArrayExtra("questions");
                String count = launchMe.getStringExtra("countQ");
                String correctCount = launchMe.getStringExtra("correctCount");
                Intent nextActivity = new Intent(QuestionActivity.this, SummaryActivity.class);

                if (count.equalsIgnoreCase("2")){
                    nextActivity.putExtra("countQ", "2");
                } else {
                    nextActivity.putExtra("countQ", "1");
                }
                nextActivity.putExtra("topic", topic);
                nextActivity.putExtra("answer", "You have chosen: " + qa2[choice]);
                nextActivity.putExtra("answerC", "Correct answer: " + qa2[5]);

                if (qa2[choice].equalsIgnoreCase(qa2[5])){
                    if(correctCount.equalsIgnoreCase("1")){
                        nextActivity.putExtra("correctCount", "2");
                    } else {
                        nextActivity.putExtra("correctCount", "1");
                    }
                } else {
                    if(correctCount.equalsIgnoreCase("1")) {
                        nextActivity.putExtra("correctCount", "1");
                    } else {
                        nextActivity.putExtra("correctCount", "0");
                    }
                }

                if (nextActivity.resolveActivity(getPackageManager()) != null){
                    startActivity(nextActivity);
                }
                finish();
            }
        });

    }

    public void onRadioButtonClicked(View v) {
        Button nextQuestion = (Button) findViewById(R.id.button5);
        // Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();
        nextQuestion.setVisibility(View.VISIBLE);
        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.radioButton1:
                if (checked)
                    choice = 1;
                    break;
            case R.id.radioButton2:
                if (checked)
                    choice = 2;
                    break;
            case R.id.radioButton3:
                if (checked)
                    choice = 3;
                    break;
            case R.id.radioButton4:
                if (checked)
                    choice = 4;
                    break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question, menu);
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
