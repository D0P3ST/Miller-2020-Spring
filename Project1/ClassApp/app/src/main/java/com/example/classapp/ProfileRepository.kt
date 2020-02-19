package com.example.classapp

import java.util.*

object ProfileRepository {

    private val userlist = mutableListOf<UserModal>()
    private var profile:UserModal? = null


    fun userList(): List<UserModal> {
        return Collections.unmodifiableList(userlist)
    }

    fun addUser(user: UserModal) {
        userlist.add(user)
    }

    fun loginUser(profile: UserModal): Boolean {
        if (userlist.any{x -> x.Username == profile.Username} && userlist.any{x -> x.Password == profile.Password}){

            this.profile = profile
            this.profile!!.LoggedIn = true
            return true
        }
        return false
    }

    fun logoutUser(profile: UserModal): Boolean {
        if (userlist.any{x -> x.Username == profile.Username}){
            this.profile = null
            this.profile!!.LoggedIn = false
            return true
        }
        return false
    }
}