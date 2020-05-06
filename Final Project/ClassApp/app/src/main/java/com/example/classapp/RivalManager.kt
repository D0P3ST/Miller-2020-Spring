package com.example.classapp

import io.objectbox.kotlin.query
import io.objectbox.query.QueryBuilder

object RivalManager {
    val rivalBox = ObjectBox.boxStore.boxFor(Rival::class.java)

    var currentResults:MutableList<Rival>? = null

    val query = rivalBox.query {
        order(Rival_.height, QueryBuilder.DESCENDING)
        less(Rival_.weight, 5)
//        greater(ToDoItem_.todoDueDate, Date())
    }

    private val rivalList:MutableList<Rival> by lazy{
        currentResults = query.find()

        currentResults!!
    }

    // val entity = box.query()
    //        .equal(StringIdEntity_.uid, uid, StringOrder.CASE_SENSITIVE)
    //        .build().findUnique()

    fun addRival(Rival: Rival){
        rivalBox.put(Rival)
    }

    fun rivalList():MutableList<Rival>{
        currentResults = query.find()
        return currentResults!!
    }
}
