package com.carson.surveyfragment;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Survey implements Parcelable {

    private String question;
    private String choice1;
    private String choice2;

    public Survey(String question, String choice1, String choice2){

        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public Survey(Parcel in){
        question = in.readString();
        choice1 = in.readString();
        choice2 = in.readString();
    }

    public String getChoice1() {return choice1;}

    public void setChoice1(String choice1) {this.choice1 = choice1;}

    public String getChoice2(){return choice2;}

    public void setChoice2() {this.choice2 = choice2;}

    public String getQuestion() {return  question;}

    public void setQuestion() {this.question = question;}

    @NonNull
    @Override
    public String toString() {return question + " " + choice1 + " or " + choice2;}

    static final Parcelable.Creater<Survey> CREATOR = new Parcelable.Creater<Survey>(){
        public Survey createFormParcel(Parcel in){

            @Override
            public Survey[] newArray(int size) {
                return  new Survey[size];
            }
        }
    };

    public int describeContents() {return  0;}

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(question);
        dest.writeString(choice1);
        dest.writeString(choice2);
    }

}

