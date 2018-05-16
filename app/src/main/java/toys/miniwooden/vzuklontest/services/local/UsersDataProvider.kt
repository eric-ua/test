package toys.miniwooden.vzuklontest.services.local

import android.content.Context
import retrofit2.Response
import retrofit2.Retrofit
import toys.miniwooden.vzuklontest.UklonTestApplication
import toys.miniwooden.vzuklontest.model.api.ApiUserItem
import toys.miniwooden.vzuklontest.services.remote.IUsersService
import javax.inject.Inject

class UsersDataProvider(val context: Context) : IUsersDataProvider {

    @Inject
    lateinit var dbManager: IDBManager

    @Inject
    lateinit var retrofit: Retrofit

    private var service: IUsersService

    init {
        UklonTestApplication.diComponent.inject(this)
        service = retrofit.create(IUsersService::class.java)
    }

    private var memCache: Array<ApiUserItem>? = null

    override fun getUsers(force: Boolean): Array<ApiUserItem>? {
        if (memCache == null || force) {
            val response = service.getUsers().execute()
            if (response.isSuccessful) {
                memCache = response.body()
                dbManager.save(memCache)
            }
        }

        return memCache
    }

    override fun getUser(userId: Int, force: Boolean): ApiUserItem? {
        if (force || memCache == null) {
            val response: Response<ApiUserItem> = service.getUser(userId).execute()
            if (response.isSuccessful)
                return response.body()
        }

        return memCache?.find { apiPostItem: ApiUserItem -> apiPostItem.id == userId }
    }

}