package com.voucher.quizgame;

public class QuizQuestion {
    String question;
    String option1;
    String option2;
    String option3;
    String correctAnswer;
    Boolean isItWasCorrectOrNot;

    public QuizQuestion() {

    }

    public QuizQuestion(String question, String option1, String option2, String option3, String correctAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void submitAnswer(String answer) {
        isItWasCorrectOrNot = answer.equals(this.correctAnswer);
    }
}
