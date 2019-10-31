package com.example.mobilemoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hover.sdk.api.Hover;
import com.hover.sdk.api.HoverParameters;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO(4) Initialise hover here
        Hover.initialize(this);

        Button buy = findViewById(R.id.btn_buy);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent intent = new HoverParameters.Builder(getApplicationContext())
                    // here is how to set debug mode with usehover this mode will show tht normal ussd dialog
                    .setEnvironment()
                    .request("action_id")
                    .extra("montat","40")
                    .extra("beneficiare","0972062484")
                    .buildIntent();
            startActivityForResult(intent,3);

            }
        });
    }
}
