package com.example.volunteer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button opportunityButton;
    private Button prepButton;
    private Button educationButton;
    private Button toolButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opportunityButton = (Button) findViewById(R.id.opportunitiesButton);
        opportunityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOpportunities();
            }
        });

        prepButton = (Button) findViewById(R.id.prepButton);
        prepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPreperation();
            }
        });

        educationButton = (Button) findViewById(R.id.educationButton);
        educationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEducation();
            }
        });

        toolButton = (Button) findViewById(R.id.toolButton);
        toolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTools();
            }
        });


    }

    public void openOpportunities() {
        Intent intent =  new Intent(this, OpportunitiesActivity.class);
        startActivity(intent);
    }

    public void openPreperation() {
        Intent intent =  new Intent(this, PrepActivity.class);
        startActivity(intent);
    }

    public void openEducation() {
        Intent intent =  new Intent(this, EducationActivity.class);
        startActivity(intent);
    }

    public void openTools() {
        Intent intent =  new Intent(this, ToolsActivity.class);
        startActivity(intent);
    }
}
