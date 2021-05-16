package com.voucher.quizgame;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class ViewModel_QuizBoard extends ViewModel {
    private Quiz_Game quiz_game;
    private String TAG = "ViewModel";
    private int count = 0;

    public ViewModel_QuizBoard() {
        super();

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        quiz_game.purgeInstance();
    }

    public Quiz_Game getInstanceQuizGame() {

        Log.d(TAG, "getInstanceQuizGame: " + count);

        if(count == 0) {
            quiz_game = Quiz_Game.getInstance();
            quiz_game.addQuestion(new QuizQuestion("Who is Australia’s head of State?","Queen Elizabeth II","Charles","Prince Edward","Queen Elizabeth II"));
            quiz_game.addQuestion(new QuizQuestion("How many time zones are there in Australia?","7","3","4","3"));
            quiz_game.addQuestion(new QuizQuestion("What is the highest mountain in Australia?","Mount Townsend","Mount Tate","Mount Kosciuszko","Mount Kosciuszko"));
            quiz_game.addQuestion(new QuizQuestion("What is the largest desert in Australia?","Great Victoria Desert","Tanami Dessert","Gibson Dessert","Great Victoria Desert"));
            quiz_game.addQuestion(new QuizQuestion("What is the most populated state in Australia?","New South Wales","Queensland","Victoria","New South Wales"));
            quiz_game.addQuestion(new QuizQuestion("What was the first public performance in the Sydney Opera House?","Circus","Sergei Prokofiev's War and Peace","Wilfrod Gordan McDonald Patridge","Sergei Prokofiev's War and Peace"));
            quiz_game.addQuestion(new QuizQuestion("When was South Australia established?","9 January 1992","11 March 1880","28 December 1836","28 December 1836"));
            quiz_game.addQuestion(new QuizQuestion("What is the main ingredient of Vegemite?","Milk","Salt","Yeast","Yeast"));
            quiz_game.addQuestion(new QuizQuestion("Which biscuit was sent to soldiers during the war?","Monte Carlos","ANZAC biscuits","Rolled oats biscuits","Rolled oats biscuits"));
            quiz_game.addQuestion(new QuizQuestion("What is a baby kangaroo called?","Joey","Cubs","Whelps","Joey"));
            quiz_game.addQuestion(new QuizQuestion("True or False. Koalas are bears?","True","False","None of these","True"));
            quiz_game.addQuestion(new QuizQuestion("What does AFL stand for?","The Australian Football League","The Aussie Football League","The Australian Federation League","The Australian Football League"));
            quiz_game.addQuestion(new QuizQuestion("Which sea is situated between Australia and New Zealand?","Red Sea","Tasman Sea","Indian ocean","Tasman Sea"));

        } else {
            quiz_game = Quiz_Game.getInstance();
        }

        count++;

        return quiz_game;
    }
}
