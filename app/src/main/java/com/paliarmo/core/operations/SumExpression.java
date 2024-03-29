package com.paliarmo.core.operations;

import android.util.Log;

import com.paliarmo.core.NumberExpression;
import com.paliarmo.core.interfaces.MathExpression;
import com.paliarmo.core.interfaces.OperationMathExpression;
//SeparationExpression
public class SumExpression extends OperationMathExpression {

    @Override
    final public NumberExpression calculate() {
        Log.d(LOG, "calculate");
        double first = a.calculate().getValue().doubleValue();
        double second = b.calculate().getValue().doubleValue();
        Double newValue = first + second;
        result = new NumberExpression(newValue);
        return result;
    }

    @Override
    public boolean isSameOperation(OperationMathExpression expression) {
        return expression instanceof SumExpression;
    }


    @Override
    public String toDisplayText() {
        return a.toDisplayText() + "\n+\n";
    }
}
