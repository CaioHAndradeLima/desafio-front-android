package com.test.pokeapp

import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import androidx.test.uiautomator.UiDevice
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get :Rule
    var rule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)

    @Test
    fun whenLoadActivity_showViewsCorrectly() {
        onView(withId(R.id.tablayout)).check(matches(isDisplayed()))
        onView(withId(R.id.search)).check(matches(isDisplayed()))
    }

    @Test
    fun whenUserTouchSearchAndPressBack_needKeepOnScreenWithSearchBarDisabled() {
        onView(withId(R.id.search)).perform(click())
        Thread.sleep(100)
        pressBack()
        pressBack()
        onView(withId(R.id.search)).check(matches(isDisplayed()))
    }

    @Test
    fun whenUserTouchSearchAndTouchAnotarTab_needCloseTheSearchBar() {
        onView(withId(R.id.search)).perform(click())
        pressBack()
        onView(withText(R.string.tab_my_pokemon)).perform(click())
        onView(withId(R.id.search)).check(matches(isDisplayed()))
    }

    private fun pressBack() {
        UiDevice
            .getInstance(InstrumentationRegistry.getInstrumentation())
            .pressBack()
    }

}