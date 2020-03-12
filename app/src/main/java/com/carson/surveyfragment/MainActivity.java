package com.carson.surveyfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
        configurationFragment.NewItemCreatedListener{

    private static final String BUNDLE_KEY_CONFIG_FRAG = "CONFIGURATION FRAGMENT";

    private configurationFragment ConfigurationFragment;
    private resultsFragment ResultsFragment;
    private surveyFragment SurveyFragment;

    private

    private  static final String TAG = "Main ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConfigurationFragment = new configurationFragment();
        ResultsFragment = new resultsFragment();
        SurveyFragment = new surveyFragment();

        if (savedInstaceState == null){
            configurationFragment ConfigurationFragment = configurationFragment.newInstance();

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragment_container, ConfigurationFragment, BUNDLE_KEY_CONFIG_FRAG);
            ft.commit();
        } else {
            //display surveyFragment with current survey

            surveyFragment SurveyFragment = surveyFragment.newInstance();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragment_container, SurveyFragment, BUNDLE_KEY_CONFIG_FRAG);
            ft.commit();

        }



    }

    //finish calling an passing data

    resultsFragment ResultesFragment = resultsFragment.newInstance();
    @Override
    public void onSaveInstanceState(@NonNull Bundle outBoundle){
        super.onSaveInstanceState(outBundle);
        outBundle.putParcelableArrayList(BUNDLE_KEY_CONFIG_FRAG);
    }
}
