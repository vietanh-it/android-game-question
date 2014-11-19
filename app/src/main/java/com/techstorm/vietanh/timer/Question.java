package com.techstorm.vietanh.timer;

import java.util.Random;

/**
 * Created by VietAnh on 14/11/2014.
 */
public class Question {
    public int a, b, operator;
    public float c;
    public String[] operString = new String[]{"+", "-", "x", ":"};
    public QuestionObject questionObject;

    public Question() {
        a = 0;
        b = 0;
        operator = 0;
        c = 0;
    }

    public QuestionObject getQuestion(int level) {
        Random r = new Random();
        questionObject = new QuestionObject();

        //RANDOM result + operator
        questionObject.setResult(r.nextBoolean());
        operator = r.nextInt(3);

        //RANDOM a, b FOR LEVEL, a >= b
        if (level > 4) {
            a = r.nextInt(level * 3);
            do {
                b = r.nextInt(level * 3);
            } while (b > a);
        } else {
            a = r.nextInt(10);
            do {
                b = r.nextInt(10);
            } while (b > a);
        }

        //RANDOM c BASED ON result
        c = Calculate(a, b, operator, questionObject.isResult(), level);
        questionObject.setQuestion(a + operString[operator] + b + " = " + c);

        return questionObject;
    }

    public float Calculate(int a, int b, int operator, boolean result, int level) {
        float calResult = 0;
        int addition;
        boolean plus;
        Random r = new Random();

        switch (operator) {
            case 0:
                calResult = a + b;
                break;
            case 1:
                calResult = a - b;
                break;
            case 2:
                calResult = a * b;
                break;
            case 3:
                calResult = a / b;
                break;
            default:
                calResult = 0;
        }

        if (!result) {
            plus = r.nextBoolean();
            if(level == 0) {
                level = 10;
            }

            do {
                addition = r.nextInt(level);
            } while (addition == 0);

            if (plus) {
                calResult += addition;
            } else {
                float minusTemp;
                do {
                    minusTemp = calResult - addition;
                } while (minusTemp < 0);
                calResult = minusTemp;
            }
        }

        return calResult;
    }
}
