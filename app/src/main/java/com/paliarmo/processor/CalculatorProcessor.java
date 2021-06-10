package com.paliarmo.processor;

import com.paliarmo.core.NumberExpression;
import com.paliarmo.core.interfaces.MathExpression;
import com.paliarmo.core.interfaces.OperationMathExpression;
import com.paliarmo.processor.interfaces.CalculatorProcessorDisplay;

public class CalculatorProcessor {
    private OperationMathExpression current;
    private NumberExpression currentOperand;
    private CalculatorProcessorDisplay display;

    public void setDisplay(CalculatorProcessorDisplay display) {
        this.display = display;
        updateDisplay();
    }

    public void onUserInput(String input){
        if (currentOperand == null || !currentOperand.canInput()){
            currentOperand = new NumberExpression();
        }
        currentOperand.appendInput(input);
        currentOperand.calculate();
        updateDisplay();
    }

    public void addExpression(MathExpression expression) {
        if (expression instanceof NumberExpression) {
            if (current == null) {
                currentOperand = (NumberExpression) expression;
                updateDisplay();
            } else {
                calculateExpression();
            }
        }
        if (expression instanceof OperationMathExpression) {
            calculateExpression();
            if (((OperationMathExpression) expression).isSameOperation(current) && !current.canCalculate()) {
                return;
            }else{
                current = (OperationMathExpression) expression;
            }
            calculateExpression();
        }


    }

    public void calculateExpression(){
        if (current == null) {
            updateDisplay();
            return;
        }
        current.addOperand(currentOperand);
        currentOperand = null;
        if (current.canCalculate()){
            currentOperand = current.calculate();
            current = null;
        }
        updateDisplay();
    }

    private void updateDisplay(){
        if (display == null) { return; }

        if (current != null){
            String operandText = currentOperand == null ? "" :currentOperand.toDisplayText();
            display.showOnDisplay(current.toDisplayText()+operandText);
        }else if (currentOperand != null) {
            display.showOnDisplay(currentOperand.toDisplayText());
        }else{
            display.showOnDisplay("0");
        }
    }

    public void cancelExpression() {
        if (currentOperand != null) {
            currentOperand = null;
        }else if (current != null ){
            currentOperand = (NumberExpression) current.cancel();
            current = null;
        }
        updateDisplay();

    }
}
