package com.techstorm.vietanh.questiongame;

import java.util.Random;

/**
 * Created by VietAnh on 18/11/2014.
 */
public class QuestionGenerator {

    public QuestionGenerator() {
    }

    public QuestionObject getQuestion(int level) {
        QuestionObject object = new QuestionObject();

        //VARIABLES
        level++;
        int a, b, operatorInt;
        float mathResult = 0;
        boolean questionResult;
        String operatorString = "", question;
        Random rd = new Random();

        //RANDOM a, b, questionResult, operator
        questionResult = rd.nextBoolean();
        operatorInt = rd.nextInt(3);
        switch (operatorInt) {
            case 0:
                operatorString = "+";
                break;
            case 1:
                operatorString = "-";
                break;
            case 2:
                operatorString = "x";
                break;
            case 3:
                operatorString = ":";
                break;
        }
        if (level < 5) {
            do {
                a = rd.nextInt(10);
                do {
                    b = rd.nextInt(10);
                } while (operatorInt == 3 && b == 0);
            } while (a < b && (operatorInt == 1 || operatorInt == 3));
        } else {
            do {
                int randomMax = level * 2;
                a = rd.nextInt(randomMax);
                do {
                    b = rd.nextInt(randomMax);
                } while (operatorInt == 3 && b == 0);
            } while (a < b && (operatorInt == 1 || operatorInt == 3));
        }

        mathResult = Calculate(a, b, operatorInt);

        //RANDOM mathResult
        if (!questionResult) {
            int temp = 0;
            do {
                temp = rd.nextInt(level);
            } while (temp == 0);
            if (rd.nextBoolean()) {
                mathResult += temp;
            } else {
                mathResult -= temp;
            }
        }

        question = a + " " + operatorString + " " + b + "= " + formatFloat(mathResult);

        object.setResult(questionResult);
        object.setQuestion(question);

        return object;
    }

    private float Calculate(int a, int b, int operator) {
        float mathResult = 0;

        switch (operator) {
            case 0:
                mathResult = a + b;
                break;
            case 1:
                mathResult = a - b;
                break;
            case 2:
                mathResult = a * b;
                break;
            case 3:
                mathResult = a / b;
                break;
        }

        return mathResult;
    }

    public static String formatFloat(float d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }
}
