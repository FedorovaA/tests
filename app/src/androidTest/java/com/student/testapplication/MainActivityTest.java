package com.student.testapplication;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.AndroidJUnitRunner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<> (MainActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void setOnSumClick() throws Exception{
        Espresso.onView(withId(R.id.edt_first)).perform(typeText("1"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.ed_second)).perform(typeText("2"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.btn_sum)).perform(click());
        Espresso.onView(withId(R.id.txt_res)).check(matches(withText("3")));
    }

    @Test
    public void setOnSubClick() throws Exception{
        Espresso.onView(withId(R.id.edt_first)).perform(typeText("1"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.ed_second)).perform(typeText("2"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.btn_sub)).perform(click());
        Espresso.onView(withId(R.id.txt_res)).check(matches(withText("-1")));
    }

    @Test
    public void setOnMultClick() throws Exception{
        Espresso.onView(withId(R.id.edt_first)).perform(typeText("3"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.ed_second)).perform(typeText("4"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.btn_mult)).perform(click());
        Espresso.onView(withId(R.id.txt_res)).check(matches(withText("12")));
    }

    @Test
    public void setOnDivClick() throws Exception{
        Espresso.onView(withId(R.id.edt_first)).perform(typeText("3"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.ed_second)).perform(typeText("0"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.btn_div)).perform(click());
        Espresso.onView(withId(R.id.txt_res)).check(matches(withText("")));
    }
}