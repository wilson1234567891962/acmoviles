package com.co.retrofit.app.ui.activities

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import com.co.retrofit.app.R
import com.co.retrofit.app.feature.view.activities.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.jvm.internal.Intrinsics


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

    @Test
    fun artistDetail() {
        val artistastBtn = onView(allOf(withId(R.id.navigation_artist_list), isDisplayed()))
        artistastBtn.perform(click())
        val artistsList = onView(allOf(withId(R.id.rv_artists_list)))
        artistsList.check(ViewAssertions.matches(isDisplayed()))

        val artistBtn = onView(withId(R.id.rv_artists_list))
            .check(ViewAssertions.matches(atPosition(0, hasDescendant(withText("Rub??n Blades Bellido de Luna")))))

        artistBtn.perform(click())

        onView(ViewMatchers.withId(R.id.artist_name))
            .check(ViewAssertions.matches(hasValueEqualTo("Rub??n Blades Bellido de Luna")))

    }

    fun atPosition(position: Int, itemMatcher: Matcher<View?>): Matcher<View?>? {
        Intrinsics.checkNotNull(itemMatcher)
        return object : BoundedMatcher<View?, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("has item at position $position: ")
                itemMatcher.describeTo(description)
            }

            override fun matchesSafely(view: RecyclerView): Boolean {
                val viewHolder = view.findViewHolderForAdapterPosition(position)
                    ?: // has no item on such position
                    return false
                return itemMatcher.matches(viewHolder.itemView)
            }
        }
    }

    fun hasValueEqualTo(content: String): Matcher<View?>? {
        return object : TypeSafeMatcher<View?>() {
            override fun describeTo(description: Description) {
                description.appendText("Has EditText/TextView the value:  $content")
            }

            override fun matchesSafely(view: View?): Boolean {
                if (view !is TextView && view !is EditText) {
                    return false
                }
                if (view != null) {
                    val text: String
                    text = if (view is TextView) {
                        view.text.toString()
                    } else {
                        (view as EditText).text.toString()
                    }
                    return text.equals(content, ignoreCase = true)
                }
                return false
            }
        }
    }


}