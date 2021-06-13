package com.paliarmo.core.interfaces;

import android.util.Log;

import com.paliarmo.core.NumberExpression;

public abstract class OperationMathExpression implements MathExpression {
    protected MathExpression a;
    protected MathExpression b;

    protected String LOG = "OperationMathExpression";
    protected NumberExpression result;

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

    public boolean canCalculate() {
        return a!=null && b!=null;
    }

    public MathExpression cancel() {
        return a;
    }

    abstract public boolean isSameOperation(OperationMathExpression expression);
}
