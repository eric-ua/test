package toys.miniwooden.vzuklontest.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import toys.miniwooden.vzuklontest.R
import toys.miniwooden.vzuklontest.model.api.ApiCommentItem
import toys.miniwooden.vzuklontest.ui.viewholder.CommentItemViewHolder

class CommentsListAdapter : RecyclerView.Adapter<CommentItemViewHolder>() {

    var items: Array<ApiCommentItem>? = null
        set(value) {
            field = value
            notifyDataSetChanged();
        }

    var onItemClick: View.OnClickListener? = null

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(
                        R.layout.comment_list_item,
                        parent,
                        false)

        view.setOnClickListener(View.OnClickListener {
            onItemClick?.onClick(it)
        })

        return CommentItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentItemViewHolder, position: Int) {
        val item = items?.get(position)
        holder.name!!.text = item?.name
        holder.email!!.text = item?.email
        holder.body!!.text = item?.body
    }

}