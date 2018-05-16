package toys.miniwooden.vzuklontest.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.post_list_item.view.*

class PostItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    val title = itemView?.title;
    val body = itemView?.body;

}