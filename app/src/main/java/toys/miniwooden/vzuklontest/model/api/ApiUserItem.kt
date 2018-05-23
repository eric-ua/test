package toys.miniwooden.vzuklontest.model.api

import com.google.gson.annotations.Expose

data class ApiUserItem(

        @Expose val name: String?,
        @Expose val username: String?,
        @Expose val email: String?,
        @Expose val address: ApiAddress?,
        @Expose val phone: String?,
        @Expose val website: String?,
        @Expose val company: ApiCompany?

) : BaseApiItem()