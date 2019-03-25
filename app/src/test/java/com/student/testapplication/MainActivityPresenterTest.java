package com.student.testapplication;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {
private MainActivityPresenter mainActivityPresenter;
@Mock
private MainActivityView mainActivityView;

    @Before
    public void setUp() throws Exception {
        mainActivityPresenter = new MainActivityPresenter();
        mainActivityPresenter.setView(mainActivityView);
    }

    @Test
    public void shouldSumResult() throws Exception{
        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(3));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(3));
        mainActivityPresenter.onSum(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onResult(6);

        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(-1));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(-1));
        mainActivityPresenter.onSum(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onResult(-2);

        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(-1));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(1));
        mainActivityPresenter.onSum(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onResult(0);

        when(mainActivityView.getNumber1()).thenReturn("");
        when(mainActivityView.getNumber2()).thenReturn("");
        mainActivityPresenter.onSum(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onError("Поля пустые");
    }
    @Test
    public void shouldMultResult() throws Exception{
        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(32));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(33));
        mainActivityPresenter.onMult(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onResult(1056);

        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(-1));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(-1));
        mainActivityPresenter.onMult(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onResult(1);

        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(-1));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(1));
        mainActivityPresenter.onMult(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onResult(-1);

        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(0));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(1));
        mainActivityPresenter.onMult(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onResult(0);

        when(mainActivityView.getNumber1()).thenReturn("");
        when(mainActivityView.getNumber2()).thenReturn("");
        mainActivityPresenter.onMult(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onError("Поля пустые");
    }
    @Test
    public void shouldSubResult() throws Exception{
        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(-1));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(1));
        mainActivityPresenter.onSub(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onResult(-2);

        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(-1));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(-1));
        mainActivityPresenter.onSub(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onResult(0);

        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(32));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(30));
        mainActivityPresenter.onSub(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onResult(2);

        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(0));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(1));
        mainActivityPresenter.onSub(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onResult(-1);

        when(mainActivityView.getNumber1()).thenReturn("");
        when(mainActivityView.getNumber2()).thenReturn("");
        mainActivityPresenter.onSub(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onError("Поля пустые");
    }
    @Test
    public void shouldDivResult() throws Exception{
        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(25));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(5));
        mainActivityPresenter.onDiv(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onResult(5);

        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(-5));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(5));
        mainActivityPresenter.onDiv(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onResult(-1);

        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(-37));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(-35));
        mainActivityPresenter.onDiv(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onResult(1);

        when(mainActivityView.getNumber1()).thenReturn(String.valueOf(0));
        when(mainActivityView.getNumber2()).thenReturn(String.valueOf(0));
        mainActivityPresenter.onDiv(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onError("Деление на 0");

        when(mainActivityView.getNumber1()).thenReturn("");
        when(mainActivityView.getNumber2()).thenReturn("");
        mainActivityPresenter.onDiv(mainActivityView.getNumber1(),mainActivityView.getNumber2());
        verify(mainActivityView).onError("Поля пустые");
    }



}