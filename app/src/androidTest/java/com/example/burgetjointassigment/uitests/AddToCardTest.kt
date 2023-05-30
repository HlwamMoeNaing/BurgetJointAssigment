package com.example.burgetjointassigment.uitests
import androidx.test.espresso.Espresso.onView
import com.example.burgetjointassigment.R
import android.content.Intent
import android.view.View
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.burgetjointassigment.activities.MainActivity
import com.example.burgetjointassigment.uitests.utils.first
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
open class AddToCardTest {

    private val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }
@Test
fun tapAddToCard_numberOfItemsInCartIncreased(){
    onView(first<View>(withId(R.id.btnAddToCart)))
        .perform(ViewActions.click())

    onView(withId(R.id.tvCartCount))
        .check(ViewAssertions.matches(ViewMatchers.withText("1")))
}

}