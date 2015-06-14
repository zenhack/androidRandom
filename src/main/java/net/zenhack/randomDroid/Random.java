package net.zenhack.randomDroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Random extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    private int choose(int left, int right, int rand) {
        return Math.abs(rand) % (Math.abs(left - right) + 1) + Math.min(left,right);
    }

    private int OrFallback(String input, int fallback) {
        if(input.equals("")) {
            return fallback;
        }
        return Integer.parseInt(input);
    }

    public void generate(View view) {
        String left = ((EditText)findViewById(R.id.left)).getText().toString();
        String right = ((EditText)findViewById(R.id.right)).getText().toString();
        TextView answer = (TextView)findViewById(R.id.answer);
        java.util.Random rand = new java.util.Random();
        try {
            answer.setText("" + choose(OrFallback(left, 1), OrFallback(right, 10), rand.nextInt()));
        } catch(NumberFormatException e) {
            // This shouldn't be possible; We're special-casing the empty string, and the widget
            // we're using shouldn't allow the user to input anything that's not a digit. If we
            // get here, it's a bug.
            answer.setText("Whoops, looks like the author of this app made a mistake! " +
                    "Please send an email to: \n\n" +

                    "android-bugs+random@zenhack.net\n\n" +

                    "describing what you did just before this happened, so "  +
                    "they can try to fix the problem. They will be very grateful!");
        }
    }
}
