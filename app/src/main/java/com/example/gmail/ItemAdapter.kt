package com.example.gmail

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ItemAdapter(val items: ArrayList<ItemModel>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var itemView: View
        var itemViewHolder: ItemViewHolder

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.layout_single_item, parent, false)

            itemViewHolder = ItemViewHolder(itemView)
            itemView.tag = itemViewHolder
        } else {
            itemView = convertView
            itemViewHolder = itemView.tag as ItemViewHolder
        }

        itemViewHolder.header.text = items[position].header
        itemViewHolder.title.text = items[position].title
        itemViewHolder.content.text = items[position].content
        itemViewHolder.date.text = items[position].date

        itemViewHolder.avatar.setImageResource(items[position].avatar)

        if(items[position].isImportant==1){
            itemViewHolder.importantBtn.setBackgroundResource(R.drawable.important_yellow)
        }else{
            itemViewHolder.importantBtn.setBackgroundResource(R.drawable.important)
        }

        if(items[position].isStar ==1){
            itemViewHolder.starBtn.setBackgroundResource(R.drawable.star_yellow)
        }else{
            itemViewHolder.starBtn.setBackgroundResource(R.drawable.star)
        }

        itemViewHolder.importantBtn.setOnClickListener{

            if(items[position].isImportant==1){
                items[position].isImportant=0
            }else{
                items[position].isImportant=1
            }
            notifyDataSetChanged()
        }
        itemViewHolder.starBtn.setOnClickListener{

            if(items[position].isStar==1){
                items[position].isStar=0
            }else{
                items[position].isStar=1
            }
            notifyDataSetChanged()
        }

        return itemView
    }

    class ItemViewHolder(itemView: View) {
        val avatar: ImageView
        val header: TextView
        val title: TextView
        val content:TextView
        val starBtn: ImageView
        val importantBtn: ImageView
        val date:TextView
        init {
            avatar = itemView.findViewById(R.id.avatar)
            header = itemView.findViewById(R.id.header)
            title = itemView.findViewById(R.id.title)
            content=itemView.findViewById(R.id.content)
            date = itemView.findViewById(R.id.date)
            starBtn=itemView.findViewById(R.id.star_btn)
            importantBtn= itemView.findViewById(R.id.important_btn)

            Log.v("TAG", "findViewById")
        }
    }
}