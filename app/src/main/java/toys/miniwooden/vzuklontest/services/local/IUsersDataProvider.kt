package toys.miniwooden.vzuklontest.services.local

import toys.miniwooden.vzuklontest.model.api.ApiUserItem

interface IUsersDataProvider {

    fun getUsers(force: Boolean): Array<ApiUserItem>?

    fun getUser(userId: Int, force: Boolean): ApiUserItem?

}