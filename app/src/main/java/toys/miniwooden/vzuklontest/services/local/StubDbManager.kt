package toys.miniwooden.vzuklontest.services.local

import android.content.Context
import toys.miniwooden.vzuklontest.model.api.ApiPostItem
import toys.miniwooden.vzuklontest.model.api.ApiUserItem

class StubDbManager(val context: Context) : IDBManager {

    override fun save(item: ApiPostItem?) {

    }

    override fun save(items: Array<ApiPostItem>?) {

    }

    override fun loadPost(id: Int): ApiPostItem? {
        return null
    }

    override fun loadPost(): List<ApiPostItem>? {
        return null
    }

    override fun save(item: ApiUserItem?) {

    }

    override fun save(items: Array<ApiUserItem>?) {

    }

    override fun loadUser(id: Int): ApiUserItem? {
        return null
    }

    override fun loadUser(): List<ApiUserItem>? {
        return null
    }

}