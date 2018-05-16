package toys.miniwooden.vzuklontest.di

import android.content.Context
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import toys.miniwooden.vzuklontest.services.HttpClientSetup
import toys.miniwooden.vzuklontest.services.local.*
import javax.inject.Named
import javax.inject.Singleton

@Module
class DiModule(private val context: Context) {

    @Provides
    fun provideContext(): Context = context

    @Provides
    @Named("baseUrl")
    fun provideBaseUrl(): String = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideDbManager(): IDBManager {
        return StubDbManager(context)
    }

    @Provides
    @Singleton
    fun providePostDataProvider(): IPostsDataProvider {
        return PostDataProvider(context)
    }

    @Provides
    @Singleton
    fun provideUsersDataProvider(): IUsersDataProvider {
        return UsersDataProvider(context)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return HttpClientSetup().setupClient()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@Named("baseUrl") baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(provideOkHttpClient())
                .addConverterFactory(
                        GsonConverterFactory.create(
                                GsonBuilder()
                                        .excludeFieldsWithoutExposeAnnotation()
                                        .create()))
                .build()
    }

    @Provides
    fun provideNavigationService(): INavigationService {
        return NavigationService();
    }

}