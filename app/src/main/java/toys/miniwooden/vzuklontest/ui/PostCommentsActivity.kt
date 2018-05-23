package toys.miniwooden.vzuklontest.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_post_comments.*
import kotlinx.android.synthetic.main.user_info_block.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import toys.miniwooden.vzuklontest.R
import toys.miniwooden.vzuklontest.UklonTestApplication
import toys.miniwooden.vzuklontest.model.Constants
import toys.miniwooden.vzuklontest.model.extInfo
import toys.miniwooden.vzuklontest.services.local.IPostsDataProvider
import toys.miniwooden.vzuklontest.services.local.IUsersDataProvider
import toys.miniwooden.vzuklontest.ui.adapter.CommentsListAdapter
import javax.inject.Inject

class PostCommentsActivity : BaseActivity() {

    init {
        UklonTestApplication.diComponent.inject(this)
    }

    @Inject
    lateinit var postsDataProvider: IPostsDataProvider

    @Inject
    lateinit var usersDataProvider: IUsersDataProvider

    private lateinit var adapter: CommentsListAdapter

    private var postId: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_comments)
        setSupportActionBar(toolbar)

        postId = intent.getIntExtra(Constants.ARG_POST_ID, 0)
        if (postId <= 0)
            throw IllegalArgumentException("Something went wrong!")

        recycler.layoutManager = LinearLayoutManager(this)
        adapter = CommentsListAdapter()
        recycler.adapter = adapter

        refresh.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            updateData(true)
        })

        refresh.isRefreshing = true
        updateData(false);

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    fun updateData(force: Boolean) {
        launch(CommonPool) {
            // TODO ERiC: error handler needed
            val post = postsDataProvider.getPost(postId, force)
            val comments = postsDataProvider.getPostComments(postId)

            val user = if (post != null) usersDataProvider.getUser(post.userId, force) else null

            runOnUiThread({
                user_name.text = user?.name
                user_info.text = user?.extInfo()
                adapter.items = comments
                refresh.isRefreshing = false
            })
        }
    }

}
