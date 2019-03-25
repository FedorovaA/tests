package com.student.testapplication;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivityPresenter extends BasePresenter<MainActivityView> implements IMainActivityPresenter {
    @Override
    public void onCreate(Bundle saveInstance) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onSum(String num1, String num2) {
        if(!num1.isEmpty() && !num2.isEmpty()) {
            view.onResult(Integer.valueOf(num1) + Integer.valueOf(num2));
        }
        else {
            view.onError("Поля пустые");
        }
    }

    @Override
    public void onMult(String num1, String num2) {
        if(!num1.isEmpty() && !num2.isEmpty()) {
            view.onResult(Integer.valueOf(num1) * Integer.valueOf(num2));
        }
        else {
            view.onError("Поля пустые");
        }

    }

    @Override
    public void onSub(String num1, String num2)  {
        if(!num1.isEmpty() && !num2.isEmpty()) {
            view.onResult(Integer.valueOf(num1) - Integer.valueOf(num2));
        }
        else {
            view.onError("Поля пустые");
        }
    }

    @Override
    public void onDiv(String num1, String num2) {
        if(!num1.isEmpty() && !num2.isEmpty()) {
            if(Integer.valueOf(num2) == 0 || (Integer.valueOf(num1) == 0 && Integer.valueOf(num2) == 0))
            {
               view.onError("Деление на 0");
            }
            else
                view.onResult(Integer.valueOf(num1) / Integer.valueOf(num2));
        }
        else {
            view.onError("Поля пустые");
        }
    }
}
interface IMainActivityPresenter{
    void onSum(String num1, String num2);
    void onMult(String num1, String num2);
    void onSub(String num1, String num2);
    void onDiv(String num1, String num2);
}
