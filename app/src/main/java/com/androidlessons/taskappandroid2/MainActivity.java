package com.androidlessons.taskappandroid2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private NavController navController;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
                R.id.navigation_profile)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        navController.navigate(R.id.boardFragment);
        //определяет какой фрагмент открыть или закрыть
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                List<Integer> tabFragments = new ArrayList<>();
                tabFragments.add(R.id.navigation_home);
                tabFragments.add(R.id.navigation_dashboard);
                tabFragments.add(R.id.navigation_notifications);
                tabFragments.add(R.id.navigation_profile);

                if (tabFragments.contains(destination.getId())) {
                    navView.setVisibility(View.VISIBLE);
                } else {
                    navView.setVisibility(View.GONE);
                }

                // прячем toolbar в boardFragment
                if (destination.getId() == R.id.boardFragment) {
                    getSupportActionBar().hide();
                }else {
                    getSupportActionBar().show();
                }
            }
        });

    }

    //включаем стрелку назад во фрагментах
    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();

    }

}