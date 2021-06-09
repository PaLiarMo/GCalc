package com.paliarmo.core.interfaces;

import com.paliarmo.core.NumberExpression;

public interface MathExpression {
    NumberExpression calculate();
    String toDisplayText();
}
