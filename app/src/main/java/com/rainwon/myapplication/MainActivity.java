package com.rainwon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float korzh = 10;
    private int korzhDiscount = 26;

    private float cream = 14;
    private int creamDiscount = 15;

    private float fruits = 3;
    private int fruitsDiscount = 41;

    private float nut = 5;
    private int nutDiscount = 55;

    private float berry = 7;

    private float balance = 45;

    private TextView possibilityOut;
    private TextView balanceOut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        possibilityOut = findViewById(R.id.possibilityOut);
        balanceOut = findViewById(R.id.balanceOut);

        if (possibility()) {
            possibilityOut.setText("Средств достаточно");
            balanceOut.setText("Остаток от покупки " + getbalance());
        } else {
            possibilityOut.setText("Средств недостаточно");
            balanceOut.setText(" - ");
        }

    }




    private float calculation() {
        float count = (korzh * (100 - korzhDiscount) + cream * (100 - creamDiscount)
                + fruits * (100 - fruitsDiscount) + nut * (100 - nutDiscount)
                + berry);
        return count;
    }

    private boolean possibility() {
        if (calculation() <= balance) {
            return true;
        } else {
            return false;
        }
    }

    private float getbalance() {
        if(possibility()) {
            return balance - calculation();
        } else {
            return -1;
        }
    }




}