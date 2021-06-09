package com.paliarmo.core;

import com.paliarmo.core.interfaces.MathExpression;

public class NumberExpression implements MathExpression {
    private StringBuilder numbValue;
    private Integer value;
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
    public NumberExpression(Integer value){
        this.value = value;
    }
    public NumberExpression(Double value){
        this.dvalue = value;
    }
    @Override
    public NumberExpression calculate() {
        if (numbValue != null) {
            String numString = numbValue.toString();
            try {
                value = Integer.parseInt(numString);
                dvalue = null;
            }catch (NumberFormatException e){
                value = null;
                dvalue = Double.parseDouble(numString);
            }
        }
        return this;
    }

    public Number getValue() {
        if (value != null) {
            return value;
        }else if (dvalue != null){
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
