package toys.miniwooden.vzuklontest.model.api

import com.google.gson.annotations.Expose

abstract class BaseApiItem {
    @Expose
    val id: Int = 0;
}