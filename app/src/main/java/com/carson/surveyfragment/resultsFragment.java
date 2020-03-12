package com.carson.surveyfragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.content.ContentValues.TAG;


public class resultsFragment extends Fragment {

    private static final String ARG_RESULTS = "survey results argument";
    private static final String TAG = "RESULTS FRAG";

    private Button resetButton;
    private TextView resultsChoice1;
    private TextView resultsChoice2;
    private TextView results1;
    private TextView results2;

    public resultsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false);

        if (getArguments() != null && getArguments().getParcelable(ARG_RESULTS) != null) {

            final ResultsItem results = getArguments().getParcelable(ARG_RESULTS);

            resetButton = view.findViewById(R.id.reset_button);
            resultsChoice1 = view.findViewById(R.id.resultsChoice1);
            resultsChoice2 = view.findViewById(R.id.resultsChoice2);
            results1 = view.findViewById(R.id.results1);
            results2 = view.findViewById(R.id.results2);

            setResults(results);
        } else {
            Log.w(TAG, "Did not receive a results item" );
        }
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void setResults (ResultsItem results) {
        final ResultsItem resultsItem = results;

        results1.setText(results.getText());
        results2.setText(results.getText());
        resultsChoice1.setText(results.getText());
        resultsChoice2.setText(results.getText());


        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results1.setText("0");
                results2.setText("0");
                resultsChoice1.setText("");
                resultsChoice2.setText("");

                //need to send it to   survey and configuration fragment
            }
        });
    }


}
