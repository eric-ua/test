package toys.miniwooden.vzuklontest.services.local

import android.content.Context
import toys.miniwooden.vzuklontest.model.api.ApiCommentItem

import toys.miniwooden.vzuklontest.model.api.ApiPostItem

interface IPostsDataProvider {

    fun getPosts(force: Boolean): Array<ApiPostItem>?

    fun getPost(postId: Int, force: Boolean): ApiPostItem?

    fun getComments(): Array<ApiCommentItem>?

    fun getPostComments(postId: Int): Array<ApiCommentItem>?

    fun addPost(item: ApiPostItem)
}
