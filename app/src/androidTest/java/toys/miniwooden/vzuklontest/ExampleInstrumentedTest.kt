package toys.miniwooden.vzuklontest

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import toys.miniwooden.vzuklontest.di.DaggerDiComponent
import toys.miniwooden.vzuklontest.di.DiComponent
import toys.miniwooden.vzuklontest.di.DiModule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("toys.miniwooden.vzuklontest", appContext.packageName)

        // Dagger
        val diComponent: DiComponent = DaggerDiComponent
                .builder()
                .diModule(DiModule(appContext))
                .build()

        assertNull(diComponent.provideContext())
        assertNull(diComponent.provideDBManager())
        assertNull(diComponent.provideHttpClient())
        assertNull(diComponent.providePostsDataProvider())
        assertNull(diComponent.provideRetrofit())

    }
}
