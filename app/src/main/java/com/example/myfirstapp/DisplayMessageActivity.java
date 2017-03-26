package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.my_child_toolbar);
        setSupportActionBar(myChildToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }

    /**
     * Displays a message when floating action button is clicked. FAB appears to require it to be a direct child of CoordinatorLayout in order for it to be able to slide out of the way of the Snackbar.
     *
     * @param view
     */
    public void displaySnackbar(View view) {
        CoordinatorLayout layout = (CoordinatorLayout) findViewById(R.id.myCoordinatorLayout);
        Snackbar.make(view, "This is a simple Snackbar", Snackbar.LENGTH_LONG).setAction("CLOSE", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // action that occurs when CLOSE is clicked
            }
        }).show();
    }

}
