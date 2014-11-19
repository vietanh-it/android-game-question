package com.techstorm.vietanh.questiongame;

/**
 * Created by VietAnh on 18/11/2014.
 */
public class QuestionObject {
    private boolean result;
    private String question;

    public QuestionObject() {
        this.result = true;
        this.question = "";
    }

    public QuestionObject(boolean result, String question) {
        this.result = result;
        this.question = question;
    }

    public boolean isResult() {

        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
