package toys.miniwooden.vzuklontest.services.local

import toys.miniwooden.vzuklontest.model.api.ApiPostItem
import toys.miniwooden.vzuklontest.model.api.ApiUserItem

interface IDBManager {

    fun save(item: ApiPostItem?)
    fun save(items: Array<ApiPostItem>?)
    fun loadPost(id: Int): ApiPostItem?
    fun loadPost(): List<ApiPostItem>?

    fun save(item: ApiUserItem?)
    fun save(items: Array<ApiUserItem>?)
    fun loadUser(id: Int): ApiUserItem?
    fun loadUser(): List<ApiUserItem>?
}
