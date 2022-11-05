package com.co.retrofit.app.ui.activities

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
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
class PruebasAlbum {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun verMenuAlbumes() {
        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.navigation_album), withContentDescription("Albumes"),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())
    }

    @Test
    fun seleccionarArtistas() {
        onView(
            allOf(
                withId(R.id.navigation_artist_list), withContentDescription("Albumes"),
                isDisplayed()
            )
        )
    }



}