package com.voucher.quizgame;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quiz_Game {
    private int score;
    private java.util.List<QuizQuestion> mList;
    private String Competitionlabel;
    private int percentage;
    private List<Integer> numberContainer;
    private int current_index;
    private int sequential;
    private int previousIterator = -1;
    private static Quiz_Game instance;
    private String TAG = "Quiz Game";

    private Quiz_Game() {
        mList = new ArrayList<>();
        numberContainer = new ArrayList<>();
    }

    public void addQuestion(QuizQuestion quizQuestion) {
        mList.add(quizQuestion);
    }

    public int getTotalNumberOfQuestion() {
        return mList.size();
    }

    private int getNonRepeatingRandomNumber() {
        int total = mList.size();
        Log.d(TAG, "getNonRepeatingRandomNumber: Size: " + total);
        Random random = new Random();
        int number = 0;

        do {
            number = random.nextInt((total));
            Log.d(TAG, "getNonRepeatingRandomNumber: " + String.valueOf(number));
        } while(numberContainer.contains(number));

        numberContainer.add(number);
        return number;
    }

    public QuizQuestion getQuestion() {
        Log.d(TAG, "getQuestion: Sequence " + sequential);

        if(sequential < mList.size()) {

            if(previousIterator != sequential) {
                current_index = getNonRepeatingRandomNumber();
            }

            previousIterator = sequential;
            return mList.get(current_index);
        }

        return null;
    }

    public void SubmitAnswer(String answer) {
        mList.get(current_index).submitAnswer(answer);
        sequential++;
    }

    public int getPointScore() {
        for (QuizQuestion qq: mList) {
            if (qq.isItWasCorrectOrNot) {
                score++;
            }
        }

        return score;
    }

    public static Quiz_Game getInstance() {
        if(instance == null) {
            instance = new Quiz_Game();
        }
        return instance;
    }

    public Quiz_Game purgeInstance() {
        instance = new Quiz_Game();
        return instance;
    }
}
