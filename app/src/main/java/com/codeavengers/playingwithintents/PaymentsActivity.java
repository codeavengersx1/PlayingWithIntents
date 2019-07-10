package com.codeavengers.playingwithintents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        findViewById(R.id.btn_new_activity)
                .setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        Intent mainActivityIntent = new Intent(
                                PaymentsActivity.this, ThankYouActivity.class
                        );
                        startActivity(mainActivityIntent);
                    }
                });
    }
}
