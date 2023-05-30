package com.example.burgetjointassigment.uitests.login

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.burgetjointassigment.activities.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.burgetjointassigment.R


@RunWith(AndroidJUnit4ClassRunner::class)
open class LoginSuccessTest {

    companion object {
        const val TEST_USERNAME = "John Wick"
        const val TEST_PASSWORD = "123456"
    }


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
            .perform(ViewActions.typeText(TEST_USERNAME), ViewActions.closeSoftKeyboard())

        Espresso.onView(withId(R.id.etPassword))
            .perform(ViewActions.typeText(TEST_PASSWORD), ViewActions.closeSoftKeyboard())

        Espresso.onView(withId(R.id.btnLogin))
            .perform(ViewActions.click())

        Espresso.onView(withId(R.id.rvBurgerList))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}