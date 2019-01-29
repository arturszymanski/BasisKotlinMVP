package com.arturszymanski.basiskotlinmvp.view.user.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.arturszymanski.domain.entity.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user_list.view.*

/**
 * This class represents View Holder pattern used by RecyclerView. This VH is used to display User's data in list
 * and add interactions with this data.
 * @param itemView view that is used to display User data by this VH.
 */
class UserListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    /**
     * This function adds possibility to display User data and add interactions with this data.
     * @param user User model data to display
     * @param userListItemInteractions listener that contains all interactions that need to be handled by this view like
     * clicks and other.
     */
    fun bind(user: User, userListItemInteractions: UserListItemInteractions) {

        itemView.name.text = user.name.title + " " + user.name.first + " " + user.name.last
        itemView.dob.text = user.dob.date
        itemView.email.text = user.email

        Picasso.get()
            .load(user.picture.large)
            .into(itemView.image)

        itemView.setOnClickListener{ _ -> userListItemInteractions.itemSelected(adapterPosition) }
    }
}