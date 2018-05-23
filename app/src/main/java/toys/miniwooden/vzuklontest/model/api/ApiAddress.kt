package toys.miniwooden.vzuklontest.model.api

import com.google.gson.annotations.Expose

data class ApiAddress(
        @Expose val name: String?,
        @Expose val street: String?,
        @Expose val suite: String?,
        @Expose val city: String?,
        @Expose val zipcode: String?,
        @Expose val geo: ApiGeo?
)