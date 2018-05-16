package toys.miniwooden.vzuklontest.model.api

import com.google.gson.annotations.Expose

class ApiAddress {
    @Expose
    val name: String? = null;
    @Expose
    val street: String? = null;
    @Expose
    val suite: String? = null;
    @Expose
    val city: String? = null;
    @Expose
    val zipcode: String? = null;
    @Expose
    val geo: ApiGeo? = null;
}