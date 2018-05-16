package toys.miniwooden.vzuklontest.model.api

import com.google.gson.annotations.Expose

class ApiUserItem : BaseApiItem() {

    @Expose
    val name: String? = null;
    @Expose
    val username: String? = null;
    @Expose
    val email: String? = null;
    @Expose
    val address: ApiAddress? = null;
    @Expose
    val phone: String? = null;
    @Expose
    val website: String? = null;
    @Expose
    val company: ApiCompany? = null;

    val extInfo: String
        get() {
            return "$username\n$email\n$phone"
        }

}