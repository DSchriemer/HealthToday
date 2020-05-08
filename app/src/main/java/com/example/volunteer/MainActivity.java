package com.example.volunteer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

//    private Button opportunityButton;
//    private Button prepButton;
//    private Button educationButton;
//    private Button toolButton;
    private FrameLayout frame;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frame = (FrameLayout) findViewById(R.id.frame);
        configureNavigationDrawer();
        configureToolbar();


//        opportunityButton = (Button) findViewById(R.id.opportunitiesButton);
//        opportunityButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openOpportunities();
//            }
//        });
//
//        prepButton = (Button) findViewById(R.id.prepButton);
//        prepButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPreperation();
//            }
//        });
//
//        educationButton = (Button) findViewById(R.id.educationButton);
//        educationButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openEducation();
//            }
//        });
//
//        toolButton = (Button) findViewById(R.id.toolButton);
//        toolButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openTools();
//            }
//        });
    }

    private void configureToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void configureNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new DashboardFragment()).commit();
        navigationView.setCheckedItem(R.id.dashboard);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                int itemId = menuItem.getItemId();
                if (itemId == R.id.dashboard) {
                    fragment = new DashboardFragment();
                } else if (itemId == R.id.learn) {
                    fragment = new LearnFragment();
                } else if (itemId == R.id.profile) {
                    fragment = new ProfileFragment();
                } else if (itemId == R.id.hospital_emergency) {
                    fragment = new HospitalEmergencyFragment();
                } else if (itemId == R.id.help) {
                    fragment = new HelpFragment();
                }
                if (fragment != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, fragment);
                    transaction.commit();
                    drawerLayout.closeDrawers();
                    return true;
                }

                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //    public void openOpportunities() {
//        Intent intent =  new Intent(this, OpportunitiesActivity.class);
//        startActivity(intent);
//    }
//
//    public void openPreperation() {
//        Intent intent =  new Intent(this, PrepActivity.class);
//        startActivity(intent);
//    }
//
//    public void openEducation() {
//        Intent intent =  new Intent(this, EducationActivity.class);
//        startActivity(intent);
//    }
//
//    public void openTools() {
//        Intent intent =  new Intent(this, ToolsActivity.class);
//        startActivity(intent);
//    }
}
