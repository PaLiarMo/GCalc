package com.paliarmo.core.operations;

import android.util.Log;

import com.paliarmo.core.NumberExpression;
import com.paliarmo.core.interfaces.MathExpression;
import com.paliarmo.core.interfaces.OperationMathExpression;

public class SumExpression implements OperationMathExpression {
    private MathExpression a;
    private MathExpression b;

    private String LOG = "SumExpression";
    private NumberExpression result;

    @Override
    public void addOperand(MathExpression operand) {
        Log.d(LOG, "addOperand");
        if (a == null){
            a = operand;
            Log.d(LOG, "a = "+a.calculate().getValue());
        }else if (b == null){
            b = operand;
            Log.d(LOG, "b = "+a.calculate().getValue());
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
        Log.d(LOG, "calculate");
        if (a.calculate().getValue() instanceof Double || b.calculate().getValue() instanceof Double){
            Log.d(LOG, "work with double");
            double first = a.calculate().getValue().doubleValue();
            double second = b.calculate().getValue().doubleValue();
            Double newValue = first + second;
            Log.d(LOG, "first = "+ first);
            Log.d(LOG, "second = "+ second);
            Log.d(LOG, "sum = "+ newValue);
            result = new NumberExpression(newValue);
        }else{
            Log.d(LOG, "work with integer");
            int first = a.calculate().getValue().intValue();
            Integer second = b.calculate().getValue().intValue();
            Integer newValue = first + second;
            Log.d(LOG, "first = "+ first);
            Log.d(LOG, "second = "+ second);
            Log.d(LOG, "sum = "+ newValue);
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
