package com.techstorm.vietanh.timer;

/**
 * Created by VietAnh on 14/11/2014.
 */
public class QuestionObject {
    private String question;
    private boolean result;

    public QuestionObject() {
        question = "";
        result = true;
    }

    public QuestionObject(String question, boolean result) {
        this.question = question;
        this.result = result;
    }

    public QuestionObject(QuestionObject questionObject) {
        this.question = questionObject.getQuestion();
        this.result = questionObject.isResult();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
