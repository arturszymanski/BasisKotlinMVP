package com.arturszymanski.presenter.user

import com.arturszymanski.domain.entity.*
import com.arturszymanski.presenter.base.BasePresenter

/**
 * Presenter that provide functionalities and data for User List view
 */
class UserListPresenter : BasePresenter<UserListView>() {

    /**
     * List of users which will be displayed
     */
    var userList : MutableList<User> = mutableListOf()

    /** {@inheritDoc} */
    override fun onFirstBind() {
        //TODO Replace with API DATA
        userList.add(
                User(
                        cell = "606 505 404",
                        name = Name(
                                first = "Lorem",
                                last = "Ipsum",
                                title = "mr."),
                        id = Id(
                                name = "",
                                value = ""),
                        dob = Dob(
                                date = "11.11.1111",
                                age = 999),
                        email = "sample@example.com",
                        gender = "Male",
                        nat = "GB",
                        phone = "123456789",
                        location = Location(
                                city = "London",
                                coordinates = Coordinates(
                                        latitude = "51.495270",
                                        longitude = "-0.135928"),
                                postcode = "42-44 B444",
                                state = "Lorem",
                                street = "Ipsum",
                                timezone = Timezone(
                                        description = "Lorem",
                                        offset = "Ipsum")),
                        picture = Picture(
                                large = "https://upload.wikimedia.org/wikipedia/commons/3/38/Wikipedia_User-ICON_byNightsight.png",
                                medium = "https://upload.wikimedia.org/wikipedia/commons/3/38/Wikipedia_User-ICON_byNightsight.png",
                                thumbnail = "https://upload.wikimedia.org/wikipedia/commons/3/38/Wikipedia_User-ICON_byNightsight.png"),
                        registered = Registered(
                                age = 2,
                                date = "22.22.2222")))

        userList.add(
                User(
                        cell = "606 505 404",
                        name = Name(
                                first = "Lorem",
                                last = "Ipsum",
                                title = "mr."),
                        id = Id(
                                name = "",
                                value = ""),
                        dob = Dob(
                                date = "11.11.1111",
                                age = 999),
                        email = "sample@example.com",
                        gender = "Male",
                        nat = "GB",
                        phone = "123456789",
                        location = Location(
                                city = "London",
                                coordinates = Coordinates(
                                        latitude = "51.495270",
                                        longitude = "-0.135928"),
                                postcode = "42-44 B444",
                                state = "Lorem",
                                street = "Ipsum",
                                timezone = Timezone(
                                        description = "Lorem",
                                        offset = "Ipsum")),
                        picture = Picture(
                                large = "https://upload.wikimedia.org/wikipedia/commons/3/38/Wikipedia_User-ICON_byNightsight.png",
                                medium = "https://upload.wikimedia.org/wikipedia/commons/3/38/Wikipedia_User-ICON_byNightsight.png",
                                thumbnail = "https://upload.wikimedia.org/wikipedia/commons/3/38/Wikipedia_User-ICON_byNightsight.png"),
                        registered = Registered(
                                age = 2,
                                date = "22.22.2222")))

        userList.add(
                User(
                        cell = "606 505 404",
                        name = Name(
                                first = "Lorem",
                                last = "Ipsum",
                                title = "mr."),
                        id = Id(
                                name = "",
                                value = ""),
                        dob = Dob(
                                date = "11.11.1111",
                                age = 999),
                        email = "sample@example.com",
                        gender = "Male",
                        nat = "GB",
                        phone = "123456789",
                        location = Location(
                                city = "London",
                                coordinates = Coordinates(
                                        latitude = "51.495270",
                                        longitude = "-0.135928"),
                                postcode = "42-44 B444",
                                state = "Lorem",
                                street = "Ipsum",
                                timezone = Timezone(
                                        description = "Lorem",
                                        offset = "Ipsum")),
                        picture = Picture(
                                large = "https://upload.wikimedia.org/wikipedia/commons/3/38/Wikipedia_User-ICON_byNightsight.png",
                                medium = "https://upload.wikimedia.org/wikipedia/commons/3/38/Wikipedia_User-ICON_byNightsight.png",
                                thumbnail = "https://upload.wikimedia.org/wikipedia/commons/3/38/Wikipedia_User-ICON_byNightsight.png"),
                        registered = Registered(
                                age = 2,
                                date = "22.22.2222")))

        present { view -> view.displayUserList(userList) }
    }

    /** {@inheritDoc} */
    override fun onViewRestoreState() {
        present { view -> view.displayUserList(userList) }
    }

    //region UI
    /**
     * Method called by view once any user was selected.
     * @param position Position of selected user
     */
    fun itemSelected(position: Int) {
        //TODO Add implementation once view created
    }
    //endregion UI
}