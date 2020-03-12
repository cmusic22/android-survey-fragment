package com.carson.surveyfragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class configurationFragment extends Fragment {

    public interface NewItemCreatedListener {
        void newItemCreated(surveyFragment survey);
    }

    public configurationFragment() {

    }

    private NewItemCreatedListener mNewItemListener;

    public static configurationFragment newInstance(){
        return new configurationFragment();
    }

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);

        if (context instanceof NewItemCreatedListener){
            mNewItemListener = (NewItemCreatedListener) context;
        }else{
            throw new RuntimeException(context.toString() + " must implement NewItemCreatedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_configuration, container, false);

        Button continueButton = view.findViewById(R.id.continueButton);
        final EditText enterQuestion = view.findViewById(R.id.enterQuestion);
        final EditText choice1 = view.findViewById(R.id.choice1);
        final EditText choice2 = view.findViewById(R.id.choice2);

        // Inflate the layout for this fragment
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = enterQuestion.getText().toString();
                String choiceOne = choice1.getText().toString();
                String choiceTwo = choice2.getText().toString();

                //validation
                if (question.isEmpty() && choiceOne.isEmpty() && choiceTwo.isEmpty()){
                    Toast.makeText(getActivity(), "Please enter a question & answers.", Toast.LENGTH_LONG).show();
                    return;
                }

                surveyFragment survey = new surveyFragment(enterQuestion, choice1, choice2);

                mNewItemListener.newItemCreated(survey);
            }
        });

        return view;
    }


}
