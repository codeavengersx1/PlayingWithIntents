package com.codeavengers.playingwithintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThankYouActivity extends AppCompatActivity
{
    @BindView(android.R.id.content)
    View currentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);

        /*
        * Attach ButterKnife to ThankYouActivity
        * */
        ButterKnife.bind(this);

        /*
        * Catch the Data from Calling or Previous Activity
        * */
        Intent fekleliPishvi = getIntent();
        String fullName = fekleliPishvi.getStringExtra("key_full_name");
        String amount = fekleliPishvi.getStringExtra("key_amount");
        boolean toAddTip = fekleliPishvi.getBooleanExtra("key_to_add_tip", false);

        String message = String.format("Thank you %s for Paying Rs. %s. ",fullName, amount);
        if (toAddTip)
        {
            message = message + "Thank you for the Tip.";
        }

        /*
        * Write your own UI Logic Here+
        * */
        Snackbar.make(currentActivity, message, Snackbar.LENGTH_LONG).show();
    }
}
