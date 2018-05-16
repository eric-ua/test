package toys.miniwooden.vzuklontest.di

import android.content.Context
import dagger.Component
import dagger.android.AndroidInjector
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import toys.miniwooden.vzuklontest.ui.PostCommentsActivity
import toys.miniwooden.vzuklontest.UklonTestApplication
import toys.miniwooden.vzuklontest.services.local.*
import toys.miniwooden.vzuklontest.ui.PostsListActivity
import toys.miniwooden.vzuklontest.ui.SplashActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(DiModule::class))
interface DiComponent : AndroidInjector<UklonTestApplication> {

    fun provideContext(): Context

    fun providePostsDataProvider(): IPostsDataProvider
    fun provideDBManager(): IDBManager
    fun provideRetrofit(): Retrofit
    fun provideHttpClient(): OkHttpClient
    fun provideNavigationService(): INavigationService
    fun provideUsersDataProvider(): IUsersDataProvider

    fun inject(activity: SplashActivity)
    fun inject(activity: PostsListActivity)
    fun inject(activity: PostCommentsActivity)

    fun inject(provider: PostDataProvider)
    fun inject(provider: StubDbManager)
    fun inject(provider: UsersDataProvider)

}