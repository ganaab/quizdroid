package edu.washington.ganaab.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class OverviewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        Intent launchedMe = getIntent();
        final String overview = launchedMe.getStringExtra("description");

        TextView over = (TextView) findViewById(R.id.textView3);
        over.setText("This is the " + overview + " section.");

        String num = launchedMe.getStringExtra("number");

        TextView number = (TextView) findViewById(R.id.textView4);
        number.setText(num);

        Button begin = (Button) findViewById(R.id.button4);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(OverviewActivity.this, QuestionActivity.class);
                nextActivity.putExtra("countQ", "1");
                nextActivity.putExtra("correctCount", "0");
                if(overview.equalsIgnoreCase("math")){
                    nextActivity.putExtra("topic", "math"); // topic 0 is math
                    String[] qa = {"What is 1 + 2 - 3 * 4 / 5?", "0", "1", "2", "undefinable", "0"};
                    nextActivity.putExtra("questions", qa);
                } else if (overview.equalsIgnoreCase(("physics"))) {
                    nextActivity.putExtra("topic", "physics");//  topic 1 is physics
                    String[] qa = {"A thermometer for measuring very low temperature is called", "pyrometer", "bolometer", "cyrometer", "platinum resistant thermometer", "cyrometer"};
                    nextActivity.putExtra("questions", qa);
                } else {
                    nextActivity.putExtra("topic", "marvel");//  topic 2 is marvel super hero
                    String[] qa = {"Which one of these heroes turns into a GAINT grEeN rAgE MoNSTER?", "Captain America", "Hulk", "Ironman", "Thor", "Hulk"};
                    nextActivity.putExtra("questions", qa);
                }

                if (nextActivity.resolveActivity(getPackageManager()) != null){
                    startActivity(nextActivity);
                }
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_overview, menu);
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
