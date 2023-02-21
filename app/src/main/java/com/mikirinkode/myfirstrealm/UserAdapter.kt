package com.mikirinkode.myfirstrealm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mikirinkode.myfirstrealm.databinding.ItemUserBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.CustomViewHolder>() {

    private var userList: ArrayList<User> = ArrayList<User>()

    class CustomViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(user: User){
                binding.apply {
                    tvName.text = user.name
                    tvEmail.text = user.email
                    tvUserId.text = "id"
                }
            }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    fun setList(newList: List<User>){
        this.userList.addAll(newList)
        notifyDataSetChanged()
    }
}


