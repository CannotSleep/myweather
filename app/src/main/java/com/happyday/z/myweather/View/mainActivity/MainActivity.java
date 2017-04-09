package com.happyday.z.myweather.View.mainActivity;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.happyday.z.myweather.R;
import com.happyday.z.myweather.View.ChooseAreaFragment.ChooseAreaFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        ChooseAreaFragment fragment1 = new ChooseAreaFragment();
//        transaction.add(R.id.main_fragment, fragment1);
//        transaction.commit();
    }
}
