package toys.miniwooden.vzuklontest.services.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import toys.miniwooden.vzuklontest.model.api.ApiCommentItem
import toys.miniwooden.vzuklontest.model.api.ApiPostItem

interface IPostsService {

    @Headers("Accept: */*")
    @GET("posts")
    fun getPosts(): Call<Array<ApiPostItem>>

    @Headers("Accept: */*")
    @GET("posts/{id}")
    fun getPost(@Path("id") id: Int): Call<ApiPostItem>

    @Headers("Accept: */*")
    @GET("posts/{id}/comments")
    fun getPostComments(@Path("id") id: Int): Call<Array<ApiCommentItem>>

    @Headers("Accept: */*")
    @GET("posts/comments")
    fun getComments(): Call<Array<ApiCommentItem>>

}