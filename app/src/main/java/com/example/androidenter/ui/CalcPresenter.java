package com.example.androidenter.ui;

import android.icu.number.NumberFormatter;
import android.icu.number.NumberRangeFormatter;

import com.example.androidenter.model.Calculator;
import com.example.androidenter.model.Operator;

import java.text.DecimalFormat;

public class CalcPresenter {

    private DecimalFormat formater = new DecimalFormat();

    private CalculatorView view;
    private Calculator calculator;

    private double argOne;
    private Double argTwo;
    private Operator selectOperator;


    public CalcPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDigitPressed(int digit) {

        if (argTwo == null) {

            argOne = argOne * 10 + digit;

            showFormatted(argOne);
        } else {

            argTwo = argTwo * 10 + digit;

            showFormatted(argTwo);
        }
    }

    public void keyOnePressed() {
    }

    public void onOperatorPressed(Operator operator) {

        if (selectOperator != null) {
            argOne = calculator.perform(argOne, argTwo, selectOperator);

            showFormatted(argOne);
        }

        argTwo = 0.0;

        selectOperator = operator;


    }

    public void onDotPressed() {
    }

    private void showFormatted(double value){
        view.showResult(formater.format(value));
    }
}
