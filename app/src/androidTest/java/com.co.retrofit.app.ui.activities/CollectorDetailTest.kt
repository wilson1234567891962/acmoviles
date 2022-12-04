package com.co.retrofit.app.ui.activities

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
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

@RunWith(AndroidJUnit4::class)
@LargeTest
class CollectorDetailTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun wheTheUserOpensTheApp_heClicksOneCollector_AndHeClicksOnBack() {

        Espresso.onView(ViewMatchers.withId(R.id.navigation_collector))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.collectorRecyclerView))
            .check(
                ViewAssertions.matches(
                    atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Manolo Bellon"))
                    )
                )
            )
        Espresso.onView(ViewMatchers.withId(R.id.collectorRecyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        Espresso.onView(ViewMatchers.withId(R.id.collector_email))
            .check(ViewAssertions.matches(hasValueEqualTo("manollo@caracol.com.co")))
        Espresso.onView(ViewMatchers.withId(R.id.back_detail_collector))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.collectorRecyclerView))
            .check(
                ViewAssertions.matches(
                    atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Manolo Bellon"))
                    )
                )
            )
    }

    @Test
    fun wheTheUserOpensTheApp_heClicksOneColector_AndSeeTheAlbumsOfCollector() {

        Espresso.onView(ViewMatchers.withId(R.id.navigation_collector))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.collectorRecyclerView))
            .check(
                ViewAssertions.matches(
                    atPosition(
                        1,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Jaime Monsalve"))
                    )
                )
            )
        Espresso.onView(ViewMatchers.withId(R.id.collectorRecyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                ViewActions.click()
            )
        )
        Espresso.onView(ViewMatchers.withId(R.id.collector_email))
            .check(ViewAssertions.matches(hasValueEqualTo("jmonsalve@rtvc.com.co")))

        Espresso.onView(ViewMatchers.withId(R.id.collector_telephone))
            .perform(ViewActions.swipeUp())

        Thread.sleep(1000)

        Espresso.onView(ViewMatchers.withId(R.id.albumsOfCollectorRecyclerView))
            .check(
                ViewAssertions.matches(
                    atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Poeta del pueblo"))
                    )
                )
            )
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