package toys.miniwooden.vzuklontest.model.api

import com.google.gson.annotations.Expose

data class ApiCommentItem(

        @Expose val postId: Int,
        @Expose val name: String?,
        @Expose val email: String?,
        @Expose var body: String?

) : BaseApiItem()