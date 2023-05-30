package com.example.burgetjointassigment.uitests
import com.example.burgetjointassigment.R
import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.burgetjointassigment.activities.MainActivity
import com.example.burgetjointassigment.viewholder.BurgerViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
open class GoToBurgerDetailsTest {

    private val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnBurger_navigateToBurgerDetails() {

        Espresso.onView(ViewMatchers.withId(R.id.rvBurgerList))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<BurgerViewHolder>(0,
                    ViewActions.click()
                ))

        Espresso.onView(ViewMatchers.withId(R.id.tvDetailDescription))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}