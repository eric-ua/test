package toys.miniwooden.vzuklontest.model.api

import com.google.gson.annotations.Expose

class ApiCommentItem : BaseApiItem() {
    @Expose
    val postId : Int = 0;
    @Expose
    val name : String? = null;
    @Expose
    val email : String? = null;
    @Expose
    var body: String? = null
}