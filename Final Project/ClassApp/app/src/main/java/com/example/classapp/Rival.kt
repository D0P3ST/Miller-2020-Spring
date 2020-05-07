package com.example.classapp

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*


@Entity
data class Rival(
    @Id var id:Long = 0,
    var rivalName:String,
    var rivalDescription:String,
    var age:Int = 0,
    var networth:Int = 0,
    var powerrating: Int = 0
)
