package com.co.retrofit.app.ui.activities

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import com.co.retrofit.app.R
import com.co.retrofit.app.feature.view.activities.MainActivity
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class ArtistTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun navigationArtist() {
        onView(
            allOf(
                withId(R.id.navigation_artist), withContentDescription("Artistas"),
                isDisplayed()
            )
        )
    }

    @Test
    fun bottomNavigationItemView() {
        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.navigation_artist_list), withContentDescription("Artistas"),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())
    }



}