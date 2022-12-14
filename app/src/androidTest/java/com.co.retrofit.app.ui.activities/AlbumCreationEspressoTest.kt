package com.co.retrofit.app.ui.activities

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.co.retrofit.app.R
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.co.retrofit.TestUtils.atPosition
import com.co.retrofit.TestUtils.hasValueEqualTo
import com.co.retrofit.app.feature.view.activities.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import kotlin.jvm.internal.Intrinsics

@RunWith(AndroidJUnit4::class)
@LargeTest
class AlbumCreationEspressoTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun wheTheUserOpensTheApp_heClickInCreateAlbum() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.arrow_title))
            .check(matches(hasValueEqualTo("Añadir album")))
    }

    @Test
    fun wheTheUserOpensTheApp_HeGoesTheAlbumCreate_HeFillOutTheCover() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.arrow_title))
            .check(matches(hasValueEqualTo("Añadir album")))
        onView(allOf(withId(R.id.caratula_text), isDisplayed()))
            .perform(typeText("23790125016"))
        onView(withId(R.id.caratula_text))
            .check(matches(hasValueEqualTo("23790125016")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
    }


    @Test
    fun wheTheUserOpensTheApp_HeGoesTheAlbumCreate_HeFillOutTheName() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.arrow_title))
            .check(matches(hasValueEqualTo("Añadir album")))
        onView(allOf(withId(R.id.caratula_text), isDisplayed()))
            .perform(typeText("23790125016"))
        onView(withId(R.id.caratula_text))
            .check(matches(hasValueEqualTo("23790125016")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.name_input), isDisplayed()))
            .perform(typeText("Yerli Xiomara Cortez Espalza"))
        onView(allOf(withId(R.id.name_input), isDisplayed()))
            .perform(typeText("Yerli Xiomara Cortez Espalza"))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
    }

    @Test
    fun wheTheUserOpensTheApp_HeGoesTheAlbumCreate_HeFillOutTheRelease() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.arrow_title))
            .check(matches(hasValueEqualTo("Añadir album")))
        onView(allOf(withId(R.id.caratula_text), isDisplayed()))
            .perform(typeText("23790125016"))
        onView(withId(R.id.caratula_text))
            .check(matches(hasValueEqualTo("23790125016")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.name_input), isDisplayed()))
            .perform(typeText("Yerli Xiomara Cortez Espalza"))
        onView(withId(R.id.name_input))
            .check(matches(hasValueEqualTo("Yerli Xiomara Cortez Espalza")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.artista_input), isDisplayed()))
            .perform(typeText("Test"))
        onView(withId(R.id.artista_input))
            .check(matches(hasValueEqualTo("Test")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.lanzamiento_input), isDisplayed()))
            .perform(typeText("1999-06-13"))
        onView(withId(R.id.lanzamiento_input))
            .check(matches(hasValueEqualTo("1999-06-13")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
    }


    @Test
    fun wheTheUserOpensTheApp_HeGoesTheAlbumCreate_HeFillOutTheGender() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.arrow_title))
            .check(matches(hasValueEqualTo("Añadir album")))
        onView(allOf(withId(R.id.caratula_text), isDisplayed()))
            .perform(typeText("23790125016"))
        onView(withId(R.id.caratula_text))
            .check(matches(hasValueEqualTo("23790125016")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.name_input), isDisplayed()))
            .perform(typeText("Yerli Xiomara Cortez Espalza"))
        onView(withId(R.id.name_input))
            .check(matches(hasValueEqualTo("Yerli Xiomara Cortez Espalza")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.artista_input), isDisplayed()))
            .perform(typeText("Test"))
        onView(withId(R.id.artista_input))
            .check(matches(hasValueEqualTo("Test")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.lanzamiento_input), isDisplayed()))
            .perform(typeText("1999-06-13"))
        onView(withId(R.id.lanzamiento_input))
            .check(matches(hasValueEqualTo("1999-06-13")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.Genero_input), isDisplayed()))
            .perform(typeText("Salsa"))
        onView(withId(R.id.Genero_input))
            .check(matches(hasValueEqualTo("Salsa")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
    }

    @Test
    fun wheTheUserOpensTheApp_HeGoesTheAlbumCreate_HeFillOutTheDiscography() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.arrow_title))
            .check(matches(hasValueEqualTo("Añadir album")))
        onView(allOf(withId(R.id.caratula_text), isDisplayed()))
            .perform(typeText("23790125016"))
        onView(withId(R.id.caratula_text))
            .check(matches(hasValueEqualTo("23790125016")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.name_input), isDisplayed()))
            .perform(typeText("Yerli Xiomara Cortez Espalza"))
        onView(withId(R.id.name_input))
            .check(matches(hasValueEqualTo("Yerli Xiomara Cortez Espalza")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.artista_input), isDisplayed()))
            .perform(typeText("Test"))
        onView(withId(R.id.artista_input))
            .check(matches(hasValueEqualTo("Test")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.lanzamiento_input), isDisplayed()))
            .perform(typeText("1999-06-13"))
        onView(withId(R.id.lanzamiento_input))
            .check(matches(hasValueEqualTo("1999-06-13")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.Genero_input), isDisplayed()))
            .perform(typeText("Salsa"))
        onView(withId(R.id.Genero_input))
            .check(matches(hasValueEqualTo("Salsa")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.casa_input), isDisplayed()))
            .perform(typeText("Sonic"))
        onView(withId(R.id.casa_input))
            .check(matches(hasValueEqualTo("Sonic")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
    }

    @Test
    fun wheTheUserOpensTheApp_HeGoesTheAlbumCreate_HeFillOutTheDescription() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.arrow_title))
            .check(matches(hasValueEqualTo("Añadir album")))
        onView(allOf(withId(R.id.caratula_text), isDisplayed()))
            .perform(typeText("23790125016"))
        onView(withId(R.id.caratula_text))
            .check(matches(hasValueEqualTo("23790125016")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.name_input), isDisplayed()))
            .perform(typeText("Yerli Xiomara Cortez Espalza"))
        onView(withId(R.id.name_input))
            .check(matches(hasValueEqualTo("Yerli Xiomara Cortez Espalza")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.artista_input), isDisplayed()))
            .perform(typeText("Test"))
        onView(withId(R.id.artista_input))
            .check(matches(hasValueEqualTo("Test")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.lanzamiento_input), isDisplayed()))
            .perform(typeText("1999-06-13"))
        onView(withId(R.id.lanzamiento_input))
            .check(matches(hasValueEqualTo("1999-06-13")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.Genero_input), isDisplayed()))
            .perform(typeText("Salsa"))
        onView(withId(R.id.Genero_input))
            .check(matches(hasValueEqualTo("Salsa")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.casa_input), isDisplayed()))
            .perform(typeText("Sonic"))
        onView(withId(R.id.casa_input))
            .check(matches(hasValueEqualTo("Sonic")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.descripcion_input), isDisplayed()))
            .perform(typeText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaa"))
        onView(withId(R.id.descripcion_input))
            .check(matches(hasValueEqualTo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaa")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
    }


    @Test
    fun wheTheUserOpensTheApp_HeGoesTheAlbumCreate_HeFillOutAllFields_ThenHeClicksInCancel() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.arrow_title))
            .check(matches(hasValueEqualTo("Añadir album")))
        onView(allOf(withId(R.id.caratula_text), isDisplayed()))
            .perform(typeText("23790125016"))
        onView(withId(R.id.caratula_text))
            .check(matches(hasValueEqualTo("23790125016")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.name_input), isDisplayed()))
            .perform(typeText("Yerli Xiomara Cortez Espalza"))
        onView(withId(R.id.name_input))
            .check(matches(hasValueEqualTo("Yerli Xiomara Cortez Espalza")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.artista_input), isDisplayed()))
            .perform(typeText("Test"))
        onView(withId(R.id.artista_input))
            .check(matches(hasValueEqualTo("Test")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.lanzamiento_input), isDisplayed()))
            .perform(typeText("1999-06-13"))
        onView(withId(R.id.lanzamiento_input))
            .check(matches(hasValueEqualTo("1999-06-13")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.Genero_input), isDisplayed()))
            .perform(typeText("Salsa"))
        onView(withId(R.id.Genero_input))
            .check(matches(hasValueEqualTo("Salsa")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.casa_input), isDisplayed()))
            .perform(typeText("Sonic"))
        onView(withId(R.id.casa_input))
            .check(matches(hasValueEqualTo("Sonic")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.descripcion_input), isDisplayed()))
            .perform(typeText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaa"))
        onView(withId(R.id.descripcion_input))
            .check(matches(hasValueEqualTo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaa")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.descripcion_input))
            .perform(ViewActions.swipeUp())
        onView(withId(R.id.btn_cancelar))
            .perform(click())
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
    }


    @Test
    fun wheTheUserOpensTheApp_HeGoesTheAlbumCreate_HeFillOutAllFields_ThenHeClicksInAccept() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.arrow_title))
            .check(matches(hasValueEqualTo("Añadir album")))
        onView(allOf(withId(R.id.caratula_text), isDisplayed()))
            .perform(typeText("23790125016"))
        onView(withId(R.id.caratula_text))
            .check(matches(hasValueEqualTo("23790125016")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.name_input), isDisplayed()))
            .perform(typeText("Yerli Xiomara Cortez Espalza"))
        onView(withId(R.id.name_input))
            .check(matches(hasValueEqualTo("Yerli Xiomara Cortez Espalza")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.artista_input), isDisplayed()))
            .perform(typeText("Test"))
        onView(withId(R.id.artista_input))
            .check(matches(hasValueEqualTo("Test")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.lanzamiento_input), isDisplayed()))
            .perform(typeText("1999-06-13"))
        onView(withId(R.id.lanzamiento_input))
            .check(matches(hasValueEqualTo("1999-06-13")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.Genero_input), isDisplayed()))
            .perform(typeText("Salsa"))
        onView(withId(R.id.Genero_input))
            .check(matches(hasValueEqualTo("Salsa")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.casa_input), isDisplayed()))
            .perform(typeText("Sonic"))
        onView(withId(R.id.casa_input))
            .check(matches(hasValueEqualTo("Sonic")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.descripcion_input), isDisplayed()))
            .perform(typeText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaa"))
        onView(withId(R.id.descripcion_input))
            .check(matches(hasValueEqualTo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaa")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.descripcion_input))
            .perform(ViewActions.swipeUp())
        onView(withId(R.id.btn_aceptar))
            .perform(click())
        onView(withId(R.id.textView_maitenance))
            .check(matches(hasValueEqualTo("Se presentaron problemas tecnicos por favor intente nuevamente.")))
    }

    @Test
    fun wheTheUserOpensTheApp_HeGoesTheAlbumCreate_HeFillOutAllFields_ThenHeClicksInTheBoBackIcon() {
        onView(withId(R.id.rv_album_list))
            .check(matches(atPosition(0, hasDescendant(withText("Género: Salsa")))))
        onView(withId(R.id.fab))
            .perform(click())
        onView(withId(R.id.arrow_title))
            .check(matches(hasValueEqualTo("Añadir album")))
        onView(allOf(withId(R.id.caratula_text), isDisplayed()))
            .perform(typeText("23790125016"))
        onView(withId(R.id.caratula_text))
            .check(matches(hasValueEqualTo("23790125016")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.name_input), isDisplayed()))
            .perform(typeText("Yerli Xiomara Cortez Espalza"))
        onView(withId(R.id.name_input))
            .check(matches(hasValueEqualTo("Yerli Xiomara Cortez Espalza")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.artista_input), isDisplayed()))
            .perform(typeText("Test"))
        onView(withId(R.id.artista_input))
            .check(matches(hasValueEqualTo("Test")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.lanzamiento_input), isDisplayed()))
            .perform(typeText("1999-06-13"))
        onView(withId(R.id.lanzamiento_input))
            .check(matches(hasValueEqualTo("1999-06-13")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.Genero_input), isDisplayed()))
            .perform(typeText("Salsa"))
        onView(withId(R.id.Genero_input))
            .check(matches(hasValueEqualTo("Salsa")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.casa_input), isDisplayed()))
            .perform(typeText("Sonic"))
        onView(withId(R.id.casa_input))
            .check(matches(hasValueEqualTo("Sonic")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(allOf(withId(R.id.descripcion_input), isDisplayed()))
            .perform(typeText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaa"))
        onView(withId(R.id.descripcion_input))
            .check(matches(hasValueEqualTo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaa")))
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.descripcion_input))
            .perform(ViewActions.swipeDown())
        onView(withId(R.id.arrow))
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
