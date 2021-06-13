package com.paliarmo.core.error;

import com.paliarmo.core.NumberExpression;

public class ExpressionError extends NumberExpression {
    @Override
    public NumberExpression calculate() {
        return null;
    }

    @Override
    public String toDisplayText() {
        return "Ошибка деления на ноль";
    }
}
