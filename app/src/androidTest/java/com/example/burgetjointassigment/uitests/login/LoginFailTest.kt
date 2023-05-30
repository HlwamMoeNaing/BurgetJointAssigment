package com.example.burgetjointassigment.uitests.login

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.burgetjointassigment.activities.LoginActivity
import com.example.burgetjointassigment.util.EM_LOGIN_FAIL_ERROR_MESSAGE
import com.example.burgetjointassigment.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
open class LoginFailTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<LoginActivity>()


    @Test
    fun checkLoginButtonIsDisplayed() {
        Espresso.onView(withId(R.id.btnLogin))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun enterInformation_navigateToMainScreen() {

        Espresso.onView(withId(R.id.etUserName))
            .perform(ViewActions.typeText(""), ViewActions.closeSoftKeyboard())

        Espresso.onView(withId(R.id.etPassword))
            .perform(ViewActions.typeText(""), ViewActions.closeSoftKeyboard())

        Espresso.onView(withId(R.id.btnLogin))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(com.google.android.material.R.id.snackbar_text))
            .check(ViewAssertions.matches(withText(EM_LOGIN_FAIL_ERROR_MESSAGE)))
    }
}