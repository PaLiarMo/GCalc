package com.paliarmo.core.operations;

import android.util.Log;

import com.paliarmo.core.NumberExpression;
import com.paliarmo.core.interfaces.MathExpression;
import com.paliarmo.core.interfaces.OperationMathExpression;

public class SumExpression implements OperationMathExpression {
    private MathExpression a;
    private MathExpression b;

    private NumberExpression result;

    @Override
    public void addOperand(MathExpression operand) {
        Log.d("SumExpression:", "addOperand");
        if (a == null){
            a = operand;
            Log.d("SumExpression:", "a = "+a.calculate().getValue());
        }else if (b == null){
            b = operand;
            Log.d("SumExpression:", "b = "+a.calculate().getValue());
        }
    }

    @Override
    public boolean isSameOperation(MathExpression mathExpression) {
        if (mathExpression == null){
            return false;
        }
        return mathExpression instanceof SumExpression;
    }

    @Override
    public boolean canCalculate() {
        return a!=null && b!=null;
    }

    @Override
    public NumberExpression calculate() {
        Log.d("SumExpression:", "calculate");
        if (a.calculate().getValue() instanceof Double || b.calculate().getValue() instanceof Double){
            Log.d("SumExpression:", "work with double");
            Double first = a.calculate().getValue() instanceof Double ? (Double) a.calculate().getValue() : Double.valueOf((Integer) a.calculate().getValue());
            Double second = b.calculate().getValue() instanceof Double ? (Double) b.calculate().getValue() : Double.valueOf((Integer) b.calculate().getValue());
            Double newValue = first + second;
            Log.d("SumExpression:", "first = "+ first);
            Log.d("SumExpression:", "second = "+ second);
            Log.d("SumExpression:", "sum = "+ newValue);
            result = new NumberExpression(newValue);
        }else{
            Log.d("SumExpression:", "work with integer");
            Integer first = (Integer) a.calculate().getValue();
            Integer second = (Integer) b.calculate().getValue();
            Integer newValue = first + second;
            Log.d("SumExpression:", "first = "+ first);
            Log.d("SumExpression:", "second = "+ second);
            Log.d("SumExpression:", "sum = "+ newValue);
            result = new NumberExpression(newValue);
        }

        return result;
    }

    @Override
    public String toDisplayText() {
        return a.toDisplayText() + "\n+\n";
    }

    @Override
    public MathExpression cancel() {
        return a;
    }
}
