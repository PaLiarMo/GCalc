package com.paliarmo.core;

import com.paliarmo.core.interfaces.MathExpression;

public class NumberExpression implements MathExpression {
    private StringBuilder numbValue;
    private Double dvalue;

    public boolean canInput(){
        return numbValue != null;
    }
    public void appendInput(String userInput) {
        if (userInput.equals(".") && numbValue.toString().contains(".")){
            return;
        }
        numbValue.append(userInput);
    }
    public NumberExpression(){
        numbValue = new StringBuilder();
    }
    public NumberExpression(Double value){
        this.dvalue = value;
    }
    @Override
    public NumberExpression calculate() {
        if (numbValue != null) {
            String numString = numbValue.toString();
            try {
                dvalue = Double.parseDouble(numString);
            }catch (NumberFormatException exception){
                exception.printStackTrace();
            }

        }
        return this;
    }

    public Number getValue() {
        if (dvalue != null){
            if (dvalue == Math.rint(dvalue)){
                return dvalue.intValue();
            }
            return dvalue;
        }
        return null;

    }


    @Override
    public String toDisplayText() {
        if (canInput()){
            return numbValue.toString();
        }
        return String.valueOf(getValue());
    }

}
