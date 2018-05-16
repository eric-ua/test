package toys.miniwooden.vzuklontest.model.api

import com.google.gson.annotations.Expose

class ApiPostItem : BaseApiItem() {

    @Expose
    var userId: Int = 0
    @Expose
    var title: String? = null
    @Expose
    var body: String? = null

}
