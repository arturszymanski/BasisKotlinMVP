package com.arturszymanski.basiskotlinmvp.view.user.details

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arturszymanski.basiskotlinmvp.R
import com.arturszymanski.basiskotlinmvp.view.base.BasePresenterDialogFragment
import com.arturszymanski.curriculumvitae.presenter.base.PresenterFactory
import com.arturszymanski.domain.entity.User
import com.arturszymanski.presenter.user.details.UserDetailsPresenter
import com.arturszymanski.presenter.user.details.UserDetailsView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_user_details.*

/**
 * View that represents User Details, in this case as Dialog Fragment
 */
class UserDetailsDialogFragment : BasePresenterDialogFragment<UserDetailsPresenter, UserDetailsView, UserDetailsDialogOwner>(), UserDetailsView {

    companion object {
        const val USER_KEY = "user_key"

        /**
         * Method that allow to create this dialog and pass given arguments to this dialog fragment.
         * @param user User object that is used to display user details.
         * @return Instance of [UserDetailsDialogFragment] that can be used to display this dialog.
         */
        @JvmStatic
        fun newInstance(user : User) : UserDetailsDialogFragment {
            var fragment : UserDetailsDialogFragment = UserDetailsDialogFragment()
            var bundle : Bundle = Bundle()

            bundle.putParcelable(USER_KEY,user)
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        close.setOnClickListener {
            presenter.closeSelected()
        }
    }

    //region UserDetailsView
    override fun displayUser(user: User) {
        name.text = "${user.name.first} ${user.name.last}"
        email.text = "email: ${user.email}"
        phoneCell.text = "cell: ${user.cell}"
        phone.text = "phone: ${user.phone}"

        Picasso.get()
            .load(user.picture)
            .into(image)
    }

    override fun close() {
        owner?.closed()
        dismiss()
    }
    //endregion UserDetailsView

    //region BasePresenterDialogFragment
    override fun getOwnerClass(): Class<UserDetailsDialogOwner> {
        return UserDetailsDialogOwner::class.java
    }
    //endregion

    //region Presenter
    override fun onPresenterPrepared(fromStorage: Boolean) {
        if(fromStorage || arguments == null) {
            return
        }

        var user : User = arguments!!.getParcelable(USER_KEY)
        presenter.user = user
    }

    override fun presenterClass(): Class<UserDetailsPresenter> {
        return UserDetailsPresenter::class.java
    }

    @Suppress("UNCHECKED_CAST")
    override fun prepareFactory(): PresenterFactory {
        return object : PresenterFactory() {
            override fun <T : ViewModel> createPresenter(presenterClass: Class<T>): T {
                return UserDetailsPresenter() as T
            }
        }
    }
    //endregion Presenter
}