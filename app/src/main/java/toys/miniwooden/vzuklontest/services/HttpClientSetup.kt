package toys.miniwooden.vzuklontest.services

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class HttpClientSetup() {

    private val CONNECTION_TIMEOUT = 15
    private val READ_TIMEOUT = 15
    private val WRITE_TIMEOUT = 10


    fun setupClient(interceptor: Interceptor? = null): OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.connectTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
        builder.readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
        builder.writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)

        if (interceptor != null)
            builder.addInterceptor(interceptor)

        return builder.build()
    }

}