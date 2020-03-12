package com.carson.surveyfragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.UUID;


public class surveyFragment extends Fragment {

    private static final String TAG = "SURVEY FRAGMENT";
    private static final String ARGS_SURVEY = "survey arguments";

    private Button resultsButton;
    private Button choiceOne;
    private Button choiceTwo;
    private TextView surveyQuestion;


    public surveyFragment() {
        // Required empty public constructor
    }

    public static surveyFragment newInstance(){
        final Bundle args = new Bundle();
        args.putParcelableArrayList(ARGS_SURVEY,);
        final surveyFragment fragment = new surveyFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_survey, container, false);

       if ()

       resultsButton = view.findViewById(R.id.results_button;
       choiceOne = view.findViewById(R.id.choice1);
       choiceTwo = view.findViewById(R.id.choice2);
       surveyQuestion = view.findViewById(R.id.surveyQuestion);

       // Inflate the layout for this fragment







        return view;

        //target the fields



    }


    //function to set question and buttons

    //button functions
}
