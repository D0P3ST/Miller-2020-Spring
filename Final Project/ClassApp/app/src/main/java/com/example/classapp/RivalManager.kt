package com.example.classapp

import io.objectbox.kotlin.query
import io.objectbox.query.QueryBuilder

object RivalManager {
    val rivalBox = ObjectBox.boxStore.boxFor(Rival::class.java)

    var currentResults:MutableList<Rival>? = null


    // val entity = box.query()
    //        .equal(StringIdEntity_.uid, uid, StringOrder.CASE_SENSITIVE)
    //        .build().findUnique()

    fun addRival(Rival: Rival){
        rivalBox.put(Rival)
    }

    fun rivalList():MutableList<Rival>{
        val query = rivalBox.query{
        }
        return query.find()!!
    }
}
