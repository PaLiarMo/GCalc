package com.paliarmo.core.interfaces;

import com.paliarmo.core.NumberExpression;

public interface OperationMathExpression extends MathExpression {
    void addOperand(NumberExpression operand);
    boolean canCalculate();
    NumberExpression cancel();
    boolean isSameOperation(MathExpression mathExpression);
}
