package com.arturszymanski.basiskotlinmvp.view.user.list

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arturszymanski.basiskotlinmvp.R
import com.arturszymanski.basiskotlinmvp.view.base.BasePresenterFragment
import com.arturszymanski.curriculumvitae.presenter.base.PresenterFactory
import com.arturszymanski.domain.entity.User
import com.arturszymanski.presenter.user.UserListPresenter
import com.arturszymanski.presenter.user.UserListView
import kotlinx.android.synthetic.main.fragment_user_list.*

/**
 * Fragment that display User List
 */
class UserListFragment : BasePresenterFragment<UserListPresenter, UserListView>(), UserListView {

    companion object {
        /**
         * Method that allow to create this fragment
         */
        @JvmStatic
        fun newInstance() : UserListFragment {
            return UserListFragment()
        }
    }

    /**
     * Layout manager used by RecyclerView
     */
    lateinit var layoutManager : LinearLayoutManager
    /**
     * Item separator used by RecyclerView
     */
    lateinit var dividerItemDecoration : DividerItemDecoration
    /**
     * Adapter used by RecyclerView
     */
    val adapter: UserListAdapter = UserListAdapter()

    /** {@inheritDoc} */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    /** {@inheritDoc} */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        userList.layoutManager = layoutManager
        userList.adapter = adapter
        userList.addItemDecoration(dividerItemDecoration)
    }

    //region UserListView
    /** {@inheritDoc} */
    override fun displayUserList(userList: List<User>) {
        adapter.setData(userList)
    }
    //endregion UserListView

    //region Presenter
    /** {@inheritDoc} */
    override fun onPresenterPrepared(fromStorage: Boolean) {
        adapter.presenter = presenter
    }

    /** {@inheritDoc} */
    override fun presenterClass(): Class<UserListPresenter> {
        return UserListPresenter::class.java
    }

    /** {@inheritDoc} */
    override fun prepareFactory(): PresenterFactory {
        return object : PresenterFactory() {
            override fun <T : ViewModel> createPresenter(presenterClass: Class<T>): T {
                return UserListPresenter() as T
            }
        }
    }
    //endregion Presenter
}