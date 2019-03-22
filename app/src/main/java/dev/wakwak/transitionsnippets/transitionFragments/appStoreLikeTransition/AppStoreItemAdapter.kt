package dev.wakwak.transitionsnippets.transitionFragments.appStoreLikeTransition

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import dev.wakwak.transitionsnippets.R

class AppStoreItemAdapter(private val onItemClickListener: (ViewHolder, Int) -> Unit) : RecyclerView.Adapter<AppStoreItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<View>(R.id.container).transitionName = "container:$position"
        holder.itemView.setOnClickListener { onItemClickListener(holder, position) }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
