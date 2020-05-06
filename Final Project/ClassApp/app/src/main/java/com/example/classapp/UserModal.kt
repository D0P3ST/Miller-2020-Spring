package com.example.classapp

import java.io.Serializable

data class UserModal (
    val Username: String,
    val Email: String,
    val Password: String,
    var LoggedIn: Boolean): Serializable{

}




