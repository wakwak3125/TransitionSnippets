package dev.wakwak.transitionsnippets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuRecyclerAdapter(private val menu: List<MenuItem>, private val itemClickListener: (MenuItem) -> Unit) : RecyclerView.Adapter<MenuRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_menu, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = menu.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menu = menu[position]
        holder.setText(menu.title)
        holder.setClickListener(itemClickListener, menu)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setText(text: String) {
            itemView.findViewById<TextView>(R.id.text_menu).text = text
        }

        fun setClickListener(itemClickListener: (MenuItem) -> Unit, menuItem: MenuItem) {
            itemView.setOnClickListener { itemClickListener(menuItem) }
        }
    }

    data class MenuItem(val id: Long, val title: String)
}