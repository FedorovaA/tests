package com.student.testapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    EditText first;
    TextView res;
    EditText second;
    Button sum;
    Button sub;
    Button mult;
    Button div;

    MainActivityPresenter mainActivityPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityPresenter = new MainActivityPresenter();
        first = findViewById(R.id.edt_first);
        second = findViewById(R.id.ed_second);
        mult = findViewById(R.id.btn_mult);
        div = findViewById(R.id.btn_div);
        sub = findViewById(R.id.btn_sub);
        sum = findViewById(R.id.btn_sum);
        res = findViewById(R.id.txt_res);
        mainActivityPresenter.setView(this);
        sum.setOnClickListener(v->{mainActivityPresenter.onSum(getNumber1(),getNumber2());});
        div.setOnClickListener(v->{mainActivityPresenter.onDiv(getNumber1(),getNumber2());});
        mult.setOnClickListener(v->{mainActivityPresenter.onMult(getNumber1(),getNumber2());});
        sub.setOnClickListener(v->{mainActivityPresenter.onSub(getNumber1(),getNumber2());});
    }

    @Override
    public void onResult(Integer res) {
        this.res.setText(String.valueOf(res));
    }

    @Override
    public void onError(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getNumber1() {
        return first.getText().toString();
    }

    @Override
    public String getNumber2() {
        return second.getText().toString();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
