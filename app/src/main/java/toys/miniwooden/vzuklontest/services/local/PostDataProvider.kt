package toys.miniwooden.vzuklontest.services.local

import android.content.Context
import retrofit2.Response
import retrofit2.Retrofit
import toys.miniwooden.vzuklontest.UklonTestApplication
import toys.miniwooden.vzuklontest.model.api.ApiCommentItem
import toys.miniwooden.vzuklontest.model.api.ApiPostItem
import toys.miniwooden.vzuklontest.services.remote.IPostsService
import javax.inject.Inject

class PostDataProvider(val context: Context) : IPostsDataProvider {

    init {
        UklonTestApplication.diComponent.inject(this)
    }

    @Inject
    lateinit var dbManager: IDBManager

    @Inject
    lateinit var retrofit: Retrofit

    private var service: IPostsService

    private var memCache: Array<ApiPostItem>? = null

    init {
        UklonTestApplication.diComponent.inject(this)
        service = retrofit.create(IPostsService::class.java)
    }

    override fun getPosts(force: Boolean): Array<ApiPostItem>? {
        if (memCache == null || force) {
            val response: Response<Array<ApiPostItem>> = service.getPosts().execute()
            if (response.isSuccessful) {
                memCache = response.body()
                dbManager.save(memCache)
            }
        }

        return memCache
    }

    override fun getPost(postId: Int, force: Boolean): ApiPostItem? {
        if (memCache == null || force) {
            val response: Response<ApiPostItem> = service.getPost(postId).execute()
            if (response.isSuccessful)
                return response.body()
        }

        return memCache?.find { apiPostItem: ApiPostItem -> apiPostItem.id == postId }
    }

    override fun getComments(): Array<ApiCommentItem>? {
        val response: Response<Array<ApiCommentItem>> = service.getComments().execute()
        return response.body()
    }

    override fun getPostComments(postId: Int): Array<ApiCommentItem>? {
        val response: Response<Array<ApiCommentItem>> = service.getPostComments(postId).execute()
        return response.body()
    }

    override fun addPost(item: ApiPostItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}