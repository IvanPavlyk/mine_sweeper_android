package com.example.assignment3_cmpt276_fall2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * HelpActivity class represents the help screen that contains
 * information about the developer, brief explanation of the game process
 * and contains references to the original sources of some of the media used in the project.
 */
public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getSupportActionBar().hide();
        TextView textReferences = (TextView) findViewById(R.id.textReferences);
        textReferences.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static Intent makeIntent(Context context){
        return new Intent(context, HelpActivity.class);
    }
}
