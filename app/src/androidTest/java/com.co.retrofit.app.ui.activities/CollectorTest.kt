package com.co.retrofit.app.ui.activities

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import com.co.retrofit.app.R
import com.co.retrofit.app.feature.view.activities.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.jvm.internal.Intrinsics
import androidx.test.espresso.assertion.ViewAssertions.matches



@LargeTest
@RunWith(AndroidJUnit4::class)
class CollectorTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun clickEnColeccionistas() {
        onView(withId(R.id.navigation_collector)).perform(click())
        onView(withId(R.id.collectorRecyclerView)).check(matches( atPosition(0,hasDescendant(withText("Manolo Bellon")))))
    }

    @Test
    fun NavegarOpcionesMenuPpal() {
        onView(withId(R.id.navigation_collector)).perform(click())
        onView(withId(R.id.collectorRecyclerView)).check(matches(atPosition(0, hasDescendant(withText("Manolo Bellon")))))
        onView(withId(R.id.navigation_album)).perform(click()).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_artist_list)).perform(click()).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_collector)).perform(click()).check(matches(isDisplayed()))
        //onView(withId(R.id.navigation_collector)).perform(click()).check(matches(isDisplayed()))
        //onView(withId(R.id.collectorRecyclerView)).check(matches(atPosition(0, hasDescendant(withText("Manolo Bellon")))))
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
