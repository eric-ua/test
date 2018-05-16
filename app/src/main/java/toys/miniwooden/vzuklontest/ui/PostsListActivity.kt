package toys.miniwooden.vzuklontest.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_posts_list.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import toys.miniwooden.vzuklontest.R
import toys.miniwooden.vzuklontest.UklonTestApplication
import toys.miniwooden.vzuklontest.services.local.INavigationService
import toys.miniwooden.vzuklontest.services.local.IPostsDataProvider
import toys.miniwooden.vzuklontest.ui.adapter.PostsListAdapter
import javax.inject.Inject

class PostsListActivity : BaseActivity() {

    @Inject
    lateinit var postsDataProvider: IPostsDataProvider

    @Inject
    lateinit var navigationService: INavigationService

    private lateinit var adapter: PostsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UklonTestApplication.diComponent.inject(this)
        setContentView(R.layout.activity_posts_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        recycler.layoutManager = LinearLayoutManager(this)
        adapter = PostsListAdapter()
        adapter.onItemClick = View.OnClickListener {
            // TODO doubtful logic
            val postId = it.tag!! as Int
            navigationService.openComments(this, postId)

        }
        recycler.adapter = adapter

        updateData(false)

        refresh.setOnRefreshListener {
            updateData(true)
        }
    }

    private fun updateData(force: Boolean) {
        // TODO ERiC: error handler needed
        launch(CommonPool) {
            val newItems = postsDataProvider.getPosts(true)
            runOnUiThread(Runnable {
                adapter.items = newItems
                refresh.isRefreshing = false
            })
        }
    }

}
