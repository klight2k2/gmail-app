package com.example.gmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVItemAdapter(val items: ArrayList<ItemModel>) : RecyclerView.Adapter<RVItemAdapter.RVItemViewHolder>()  {

    inner class RVItemViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView)  {
        val avatar: ImageView = itemView.findViewById(R.id.avatar)
        val header: TextView = itemView.findViewById(R.id.header)
        val title:TextView = itemView.findViewById(R.id.title)
        val content:TextView=itemView.findViewById(R.id.content)
        val date:TextView = itemView.findViewById(R.id.date)
        val starBtn: ImageView=itemView.findViewById(R.id.star_btn)
        val importantBtn: ImageView= itemView.findViewById(R.id.important_btn)

        init {
            importantBtn.setOnClickListener {
                if(items[adapterPosition].isImportant==1){
                    items[adapterPosition].isImportant=0
                }else{
                    items[adapterPosition].isImportant=1
                }
                notifyDataSetChanged()
            }

            starBtn.setOnClickListener{

                if(items[adapterPosition].isStar==1){
                    items[adapterPosition].isStar=0
                }else{
                    items[adapterPosition].isStar=1
                }
                notifyDataSetChanged()
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_single_item, parent, false)

        return RVItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RVItemViewHolder, position: Int) {
        holder.header.text = items[position].header
        holder.title.text = items[position].title
        holder.content.text = items[position].content
        holder.date.text = items[position].date

        holder.avatar.setImageResource(items[position].avatar)

        if(items[position].isImportant==1){
            holder.importantBtn.setBackgroundResource(R.drawable.important_yellow)
        }else{
            holder.importantBtn.setBackgroundResource(R.drawable.important)
        }

        if(items[position].isStar ==1){
            holder.starBtn.setBackgroundResource(R.drawable.star_yellow)
        }else{
            holder.starBtn.setBackgroundResource(R.drawable.star)
        }
    }
}