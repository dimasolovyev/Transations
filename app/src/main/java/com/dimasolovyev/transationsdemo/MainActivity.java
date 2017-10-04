package com.dimasolovyev.transationsdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    navigateToFramgent(new HomeFragment());
                    return true;
                case R.id.navigation_dashboard:
                    navigateToFramgent(new DashboardFragment());
                    return true;
                case R.id.navigation_notifications:
                    navigateToFramgent(new NotificationsFragment());
                    return true;
            }
            return false;
        }

    };

    private void navigateToFramgent(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.animator.enter, R.animator.exit, R.animator.popenter, R.animator.popexit)
                .replace(R.id.fragmentContainer, fragment);

        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            navigation.setSelectedItemId(R.id.navigation_home);
        }
    }

}
