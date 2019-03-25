package com.student.testapplication;

public interface MainActivityView extends BaseView {
    void onResult(Integer res);
    void onError(String message);
    String getNumber1();
    String getNumber2();
}
