package com.bytedance.dogadoption

import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

data class item(val imageResource : Int, val text : String, val Imformation : String)

class SearchViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
) {
//    init {
//        itemView.findViewById<TextView>(R.id.text).setOnClickListener {
////            val intent = Intent(this, ImformationActivity::class.java)
////            startActivity(intent)
//        }
//    }


    //bind a string and a image.
    fun bind(content: item) {

        itemView.findViewById<TextView>(R.id.text).text = content.text
        itemView.findViewById<ImageView>(R.id.image).setImageResource(content.imageResource)

    }

}

class SearchAdapter : RecyclerView.Adapter<SearchViewHolder>() {

    private val items = arrayListOf<item>()
    private var listener : itemListener? = null



    //  创建 ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(parent)
    }

    //  更新 ViewHolder
    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.findViewById<TextView>(R.id.text).setOnClickListener {

            listener?.onClick(position)

        }
    }

    //  控制列表项个数
    override fun getItemCount(): Int {
        return items.size
    }

    //  刷新列表项
    fun updateItems(items: List<item>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setListener(itemListener : itemListener) {

        this.listener = itemListener

    }

//    监听到click时调用onClick,overrided in mainactivity
    interface itemListener {

        fun onClick(position : Int);

    }

}