package com.co.retrofit.app.ui.activities

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import com.co.retrofit.app.R
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.co.retrofit.TestUtils.atPosition
import com.co.retrofit.TestUtils.hasValueEqualTo
import com.co.retrofit.app.feature.view.activities.MainActivity
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.jvm.internal.Intrinsics

@RunWith(AndroidJUnit4::class)
@LargeTest
class TrackTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun wheTheUserOpensTheApp_heClicksOneAlbum_AndHeShouldLookTheDetail_AndHeClicksInTheButtonMusicAdd() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.rv_album_list)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.title_album))
            .check(matches(hasValueEqualTo("Buscando América")))
        onView(withId(R.id.fab))
            .perform(click())
    }


    @Test
    fun wheTheUserOpensTheApp_HeGoesTheAddMusicOption_ThenHeClicksInCancel() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.rv_album_list)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.title_album))
            .check(matches(hasValueEqualTo("Buscando América")))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.btn_cancelar))
            .perform(click())
        onView(withId(R.id.title_album))
            .check(matches(hasValueEqualTo("Buscando América")))
    }

    @Test
    fun wheTheUserOpensTheApp_HeGoesTheAddMusicOption_ThenHeClicksInAccept() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.rv_album_list)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.title_album))
            .check(matches(hasValueEqualTo("Buscando América")))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.btn_aceptar))
            .perform(click())
        onView(withId(R.id.textView_maitenance))
            .check(matches(hasValueEqualTo("Se presentaron problemas tecnicos por favor intente nuevamente.")))
    }

    @Test
    fun wheTheUserOpensTheApp_HeGoesTheAddMusicOption_ThenHeGoBack() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.rv_album_list)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.title_album))
            .check(matches(hasValueEqualTo("Buscando América")))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.back_add_music))
            .perform(click())
        onView(withId(R.id.title_album))
            .check(matches(hasValueEqualTo("Buscando América")))
        onView(withId(R.id.back_detail_album))
            .perform(click())
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
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
