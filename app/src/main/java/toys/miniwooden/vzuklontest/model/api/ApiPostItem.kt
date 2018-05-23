package toys.miniwooden.vzuklontest.model.api

import com.google.gson.annotations.Expose

class ApiPostItem(

        @Expose var userId: Int,
        @Expose var title: String?,
        @Expose var body: String?

) : BaseApiItem()
