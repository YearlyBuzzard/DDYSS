package com.example.ddyssadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class Dashboard_admin extends AppCompatActivity {

    Home_Admin Padmin = new Home_Admin();
    FloatingActionButton crear;
    BottomNavigationView bottomnavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);

        bottomnavigationView=findViewById(R.id.bottomNavigationView);
        bottomnavigationView.setBackground(null);

        crear=(FloatingActionButton)findViewById(R.id.Crear);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,Padmin).commit();

        bottomnavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, Padmin).commit();
                        return true;
                }
                return false;
            }
        });
    }
}
