package com.example.classapp

import android.app.Application


class DatabaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
    }
}