package toys.miniwooden.vzuklontest.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import toys.miniwooden.vzuklontest.R
import toys.miniwooden.vzuklontest.model.api.ApiPostItem
import toys.miniwooden.vzuklontest.ui.viewholder.PostItemViewHolder

class PostsListAdapter : RecyclerView.Adapter<PostItemViewHolder>() {

    var items: Array<ApiPostItem>? = null
        set(value) {
            field = value
            notifyDataSetChanged();
        }

    var onItemClick: View.OnClickListener? = null

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(
                        R.layout.post_list_item,
                        parent,
                        false)

        view.setOnClickListener(View.OnClickListener {
            onItemClick?.onClick(it)
        })

        return PostItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostItemViewHolder, position: Int) {
        val item = items?.get(position)

        holder.title!!.text = item!!.title
        holder.body!!.text = item.body
        holder.itemView.tag = item.id
    }

}