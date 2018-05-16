package toys.miniwooden.vzuklontest.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import toys.miniwooden.vzuklontest.R
import toys.miniwooden.vzuklontest.UklonTestApplication
import toys.miniwooden.vzuklontest.services.local.INavigationService
import toys.miniwooden.vzuklontest.services.local.IPostsDataProvider
import toys.miniwooden.vzuklontest.services.local.IUsersDataProvider
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var navigationService: INavigationService

    @Inject
    lateinit var postsDataProvider: IPostsDataProvider

    @Inject
    lateinit var usersDataProvider: IUsersDataProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        UklonTestApplication.diComponent.inject(this)

        launch(CommonPool) {
            postsDataProvider.getPosts(true)
            usersDataProvider.getUsers(true)

            runOnUiThread(Runnable {
                navigationService.landingPage(this@SplashActivity)
                finish()
            })
        }
    }

}
