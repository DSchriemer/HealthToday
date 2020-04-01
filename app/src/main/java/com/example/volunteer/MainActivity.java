package com.example.volunteer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button opportunityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opportunityButton = (Button) findViewById(R.id.button5);
        opportunityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOpportunities();
            }
        });
    }

    public void openOpportunities() {
        Intent intent =  new Intent(this, opportunities_activity.class);
        startActivity(intent);
    }
}
