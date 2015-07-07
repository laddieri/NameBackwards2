package com.development.laddieri.namebackwards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    private EditText mNameText;
    private Button mNameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameText = (EditText)findViewById(R.id.nameText);
        mNameButton = (Button)findViewById(R.id.nameButton);

        mNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameText.getText().toString();
                toNameActivity(name);
            }
        });

    }

    private void toNameActivity (String name){
        Intent intent = new Intent(this, NameActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameText.setText("");
    }
}
