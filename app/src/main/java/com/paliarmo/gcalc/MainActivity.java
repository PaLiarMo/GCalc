package com.paliarmo.gcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.paliarmo.core.operations.MultiplyExpression;
import com.paliarmo.core.operations.SeparationExpression;
import com.paliarmo.core.operations.SubtractionExpression;
import com.paliarmo.core.operations.SumExpression;
import com.paliarmo.processor.CalculatorProcessor;
import com.paliarmo.processor.interfaces.CalculatorProcessorDisplay;

public class MainActivity extends AppCompatActivity implements CalculatorProcessorDisplay {


    private TextView calculatorOutput;
    private CalculatorProcessor processor = new CalculatorProcessor();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatorOutput = findViewById(R.id.calculation_text_view);
        processor.setDisplay(this);
    }
    public void onDigitSignClicked(View view) {
        Button clicked = (Button) view;
        if (clicked != null && processor != null) {
            processor.onUserInput(clicked.getText().toString());
        }
    }

    public void onMultiplyClicked(View view) {
        processor.addExpression(new MultiplyExpression());
    }
    public void onDividedClicked(View view) {
        processor.addExpression(new SeparationExpression());
    }
    public void onPlusClicked(View view) {
        processor.addExpression(new SumExpression());
    }
    public void onMinusClicked(View view) {
        processor.addExpression(new SubtractionExpression());
    }
    public void onChangeNumberSignClicked(View view) {

    }
    public void onPercentClicked(View view) {

    }

    public void onCancelClicked(View view) {
        processor.cancelExpression();
    }

    public void onCalculateClicked(View view) {
        processor.calculateExpression();
    }


    @Override
    public void showOnDisplay(String calculatorOutputText) {
        calculatorOutput.setText(calculatorOutputText);
    }

    @Override
    public void onError(String errorMessage) {
        calculatorOutput.setText(R.string.calc_operation_error);
    }
}