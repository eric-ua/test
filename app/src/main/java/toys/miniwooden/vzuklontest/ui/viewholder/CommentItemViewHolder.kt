package toys.miniwooden.vzuklontest.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.comment_list_item.view.*

class CommentItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    val name = itemView?.name;
    val email = itemView?.email;
    val body = itemView?.body;

}