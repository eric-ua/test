package toys.miniwooden.vzuklontest.services.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import toys.miniwooden.vzuklontest.model.api.ApiUserItem

interface IUsersService {

    @Headers("Accept: */*")
    @GET("users")
    fun getUsers(): Call<Array<ApiUserItem>>

    @Headers("Accept: */*")
    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Call<ApiUserItem>

}