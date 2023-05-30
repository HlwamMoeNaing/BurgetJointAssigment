package com.example.burgetjointassigment.uitests

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.burgetjointassigment.activities.MainActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.example.burgetjointassigment.R

@RunWith(AndroidJUnit4ClassRunner::class)
open class PlayGameTest {

    private val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnPlayGame_navigateToGameScreen() {

        Espresso.onView(withId(R.id.btnPlayGame)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.ivGameBurger))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}