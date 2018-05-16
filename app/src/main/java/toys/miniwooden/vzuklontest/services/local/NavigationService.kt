package toys.miniwooden.vzuklontest.services.local

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import toys.miniwooden.vzuklontest.ui.PostCommentsActivity
import toys.miniwooden.vzuklontest.R
import toys.miniwooden.vzuklontest.model.Constants
import toys.miniwooden.vzuklontest.ui.PostsListActivity

class NavigationService : INavigationService {
    override fun landingPage(context: Context) {
        context.startActivity(
                Intent(context, PostsListActivity::class.java)
        )

        val activity = context as AppCompatActivity
        activity?.overridePendingTransition(R.anim.right_in, R.anim.alpha);
    }

    override fun openPostsList(context: Context) {
        context.startActivity(
                Intent(context, PostsListActivity::class.java)
        )

        val activity = context as AppCompatActivity
        activity?.overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }

    override fun openComments(context: Context, postId: Int) {
        val intent = Intent(context, PostCommentsActivity::class.java)
        intent.putExtra(Constants.ARG_POST_ID, postId)
        context.startActivity(intent)

        val activity = context as AppCompatActivity
        activity?.overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }

}
