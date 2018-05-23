package toys.miniwooden.vzuklontest.model.api

import com.google.gson.annotations.Expose

data class ApiCompany(
        @Expose val name: String?,
        @Expose val catchPhrase: String?,
        @Expose val bs: String?
)