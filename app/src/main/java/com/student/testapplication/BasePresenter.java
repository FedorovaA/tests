package com.student.testapplication;

public abstract class BasePresenter<T extends BaseView> implements LifePresenter {
    protected T view;
    public BasePresenter(){}
    public void setView(T view) {
        this.view = view;
    }
}
