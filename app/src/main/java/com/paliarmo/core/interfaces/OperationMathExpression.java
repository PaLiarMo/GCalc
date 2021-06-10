package com.paliarmo.core.interfaces;

import com.paliarmo.core.NumberExpression;

public interface OperationMathExpression extends MathExpression {
    void addOperand(MathExpression operand);
    boolean canCalculate();
    MathExpression cancel();
    boolean isSameOperation(MathExpression mathExpression);
}
