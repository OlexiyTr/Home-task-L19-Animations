package com.example.home_task_l19

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.home_task_l19.databinding.ItemInfoInListBinding
import kotlinx.android.synthetic.main.item_info_in_list.view.*


class Adapter(private val context: Context) :
    RecyclerView.Adapter<Adapter.MyViewHolder>() {
    private val listOfUsers: ArrayList<UserInfo> = arrayListOf()
    var onItemClick: ((UserInfo, View, View,View) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_info_in_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = listOfUsers.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listOfUsers[position])
    }

    fun addItemToList(item: UserInfo) {
        listOfUsers.add(item)
        notifyItemInserted(listOfUsers.size - 1)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding: ItemInfoInListBinding = ItemInfoInListBinding.bind(itemView)
        private val userName = binding.tvName
        private val userAvatar = binding.ivAvatar
        private val userDescription = binding.tvDescription
        fun bind(user: UserInfo) {
            val nameOfUser = "${user.firstName} ${user.secondName}"
            userName.text = nameOfUser
            userDescription.text = user.description
            Glide.with(context)
                .load(user.imageUrl)
                .into(userAvatar)
            itemView.setOnClickListener {
                onItemClick?.invoke(
                    user,
                    binding.ivAvatar,
                    binding.tvName,
                    binding.tvDescription
                )
            }
        }

    }
}

