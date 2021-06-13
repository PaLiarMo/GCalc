package com.paliarmo.core.operations;

import android.util.Log;

import com.paliarmo.core.NumberExpression;
import com.paliarmo.core.error.ExpressionError;
import com.paliarmo.core.interfaces.OperationMathExpression;

public class SeparationExpression extends OperationMathExpression {


    @Override
    final public NumberExpression calculate()  {
        Log.d(LOG, "calculate");
        double first = a.calculate().getValue().doubleValue();
        double second = b.calculate().getValue().doubleValue();
        Double newValue = first / second;
        if (second == 0.0d){
            return null;
        }
        result = new NumberExpression(newValue);
        return result;
    }
    @Override
    public boolean isSameOperation(OperationMathExpression expression) {
        return expression instanceof SeparationExpression;
    }
    @Override
    public String toDisplayText() {
        return a.toDisplayText() + "\n÷\n";
    }
}
