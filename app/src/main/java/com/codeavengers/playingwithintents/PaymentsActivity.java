package com.codeavengers.playingwithintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentsActivity extends AppCompatActivity
{
    // TODO Task: Update the UI of this functionality. Refer uplabs.com

    @BindView(R.id.etx_name_activity_payments)
    EditText etxFullName;

    @BindView(R.id.etx_amount_activity_payments)
    EditText etxAmount;

    @BindView(R.id.checkBoxTip)
    CheckBox checkBoxTip;

    /*
    * Syntax: @BindView(id_of_view) View objectName;
    * */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        /*
        * Attach ButterKnife to this Activity
        * */
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_pay_activity_payments)
    void onPayButtonClick()
    {
        /*
        * This is how you get data from EditText #Janmabhar
        * */
        String fullName = etxFullName.getText().toString();
        String amount = etxAmount.getText().toString();

        /*
        * Check if Checkbox is Ticked
        * */
        boolean toAddTip = checkBoxTip.isChecked();

        /*
        * Take user to ThankYouActivity
        * */
        Intent thankYouIntent = new Intent(PaymentsActivity.this, ThankYouActivity.class);
        /*
        * This is how you add extra data to Intent #Janmabhar
        * */
        thankYouIntent.putExtra("key_full_name", fullName);
        thankYouIntent.putExtra("key_amount", amount);
        thankYouIntent.putExtra("key_to_add_tip", toAddTip);
        startActivity(thankYouIntent);
    }

    @OnClick(R.id.txtRateUs)
    void onRateUsClick()
    {
        String link = "https://play.google.com/store/apps/details?id=" + getPackageName();
        Uri linkInUriFormat = Uri.parse(link);

        /*
        * Code to throw user to PlayStore
        * */
        Intent playStoreIntent = new Intent(Intent.ACTION_VIEW);
        playStoreIntent.setData(linkInUriFormat);
        playStoreIntent.setPackage("com.android.vending");
        startActivity(playStoreIntent);
    }
}
