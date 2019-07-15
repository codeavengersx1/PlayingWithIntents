package com.codeavengers.playingwithintents;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{
    private Button btnStartActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * Attach ButterKnife to this Activity
        * */
        ButterKnife.bind(this);

        /*
        * Recipe to create an Activity
        * 1. Java File which should extends AppCompatActivity
        * 2. Any XML File with Some UI
        * 3. Manifest Declaration (VVVVV Imp)
        * */

        btnStartActivity = findViewById(R.id.btn_new_activity);
        btnStartActivity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                /*
                * There are two types of Intents
                * 1. Explicit Intent
                *       -- When the Source Activity and Destination Activity both are in
                *          same App.
                *
                * 2. Implicit Intent
                *       -- When the Source Activity and Destination Activity both are in
                *          Different App.
                * */

                /*
                * #Janmabhar
                * */
                Intent startNewScreenIntent = new Intent(MainActivity.this, PaymentsActivity.class);
                startActivity(startNewScreenIntent);
            }
        });









        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @OnClick(R.id.img_whatsapp_logo)
    void onWhatsAppLogoClick()
    {
        /*
        * Implicit Intent code to start WhatsApp
        * */
        /*Intent whatsIntent = new Intent(Intent.ACTION_SEND);
        // whatsIntent.setPackage("com.whatsapp");
        whatsIntent.setType("text/plain");
        startActivity(whatsIntent);*/


        String[] recipients = {"contact@itechvalley.in", "jeff@amazon.com"};

        /*
        * Code to Start Gmail (Send Feedback)
        * */
        Intent gmailIntent = new Intent(Intent.ACTION_SEND);
        // gmailIntent.setPackage("com.google.android.gm");
        gmailIntent.setType("text/plain");
        /* Body */
        gmailIntent.putExtra(Intent.EXTRA_TEXT, "This is a Email Body. \n\nRegards,\nGaurav Lonkar\nFounder,\nUADA");
        /* Subject */
        gmailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback of PlayingWithIntent App");
        /* Recipient */
        gmailIntent.putExtra(Intent.EXTRA_EMAIL, recipients);
        startActivity(gmailIntent);

        // TODO: For all other Implicit Intent Code, ask Google!
    }
}
