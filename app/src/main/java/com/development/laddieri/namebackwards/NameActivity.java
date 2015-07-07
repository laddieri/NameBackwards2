package com.development.laddieri.namebackwards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NameActivity extends Activity {

    private String mName;
    private TextView mTextView;
    private Button mNewName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        Intent intent=getIntent();
        mName = intent.getStringExtra("name");

        if (mName ==null){
            mName = "My Friend";
        }

        mTextView = (TextView)findViewById(R.id.backwardsText);

        //reverse name String
        final String reverse = new StringBuffer(mName).reverse().toString();

        //set Text of TextView (backwardsText) to the output from the reversal
        mTextView.setText(reverse);

        mNewName = (Button) findViewById(R.id.tryAgainButton);

        mNewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button shareButton = (Button) findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_message) + reverse + getString(R.string.share_message2));
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, getString(R.string.share_menu_text)));
            }
        });

    }

}
