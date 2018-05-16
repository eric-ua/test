package toys.miniwooden.vzuklontest.services.local

import android.content.Context

interface INavigationService {

    fun landingPage(context: Context)
    fun openPostsList(context: Context)
    fun openComments(context: Context, postId: Int)

}