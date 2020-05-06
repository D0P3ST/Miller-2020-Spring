package com.example.classapp

import android.content.Context
import com.example.classapp.ObjectBox.boxStore
import io.objectbox.BoxStore

object ObjectBox {
    lateinit var boxStore: BoxStore private set

    fun init(context: Context) {
        boxStore = MyObjectBox.builder().androidContext(context.applicationContext).build()
    }

}





