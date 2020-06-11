package com.anandjha770.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.faendir.rhino_android.*;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDot, btnClear, btnEqual, btnDivision, btnAdd, btnSub, btnMul, btnBracket, btnModulo;
    TextView input, output;
    String process;
    boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnDot = findViewById(R.id.btnDot);
        btnEqual = findViewById(R.id.btnEqual);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnMinus);
        btnMul = findViewById(R.id.btnMultiply);
        btnModulo = findViewById(R.id.modulo);
        btnDivision = findViewById(R.id.devision);

        btnBracket = findViewById(R.id.itemBracket);
        btnClear = findViewById(R.id.itemClear);

        input = findViewById(R.id.inputView);
        output = findViewById(R.id.outputView);


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
                output.setText("");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "0");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + ".");
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();

                process = process.replaceAll("x","*");
                process = process.replaceAll("%", "/100");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult = "";
                try{
                    Scriptable scriptable = rhino.initSafeStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult = "0";
                }
                output.setText(finalResult);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "+");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "-");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "*");
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "/");
            }
        });
        btnModulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = input.getText().toString();
                input.setText(process + "%");
            }
        });
        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBracket)
                {
                    process = input.getText().toString();
                    input.setText(process + ")");
                    checkBracket = false;
                }else {
                    process = input.getText().toString();
                    input.setText(process + "(");
                    checkBracket = true;
                }
            }
        });

    }
}
