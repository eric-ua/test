package toys.miniwooden.vzuklontest

import android.app.Application
import toys.miniwooden.vzuklontest.di.DaggerDiComponent
import toys.miniwooden.vzuklontest.di.DiComponent
import toys.miniwooden.vzuklontest.di.DiModule

class UklonTestApplication : Application() {
    companion object {
        @JvmStatic
        lateinit var diComponent: DiComponent
    }

    override fun onCreate() {
        super.onCreate()
        diComponent = DaggerDiComponent
                .builder()
                .diModule(DiModule(this))
                .build()
        diComponent.inject(this)
    }
}
