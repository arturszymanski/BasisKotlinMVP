package com.arturszymanski.basiskotlinmvp.view.user.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.arturszymanski.basiskotlinmvp.R
import com.arturszymanski.domain.entity.User
import com.arturszymanski.presenter.user.UserListPresenter

/**
 * Adapter for RecyclerView that helps to display users in user list where each item is represented by [UserListViewHolder]
 */
class UserListAdapter : RecyclerView.Adapter<UserListViewHolder>() {

    /**
     * Data used by this adapter.
     */
    var userList : MutableList<User> = mutableListOf()
    /**
     * Instance of interface that handles all interactions with this list item.
     */
    val userListItemInteractions : UserListItemInteractions = object : UserListItemInteractions {
        override fun itemSelected(position: Int) {
            if(::presenter.isInitialized) {
                presenter.itemSelected(position)
            }
        }
    }
    /**
     * Presenter that handles interactions on this list and it's items.
     */
    lateinit var presenter : UserListPresenter


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_list, parent, false)
        return UserListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(userList[position], userListItemInteractions)
    }

    /**
     * This method allow to set data for adapter to display.
     * @param userList List of users that will be displayed.
     */
    fun setData(userList: List<User>) {
        this.userList.clear()
        this.userList.addAll(userList)
        notifyDataSetChanged()
    }
}