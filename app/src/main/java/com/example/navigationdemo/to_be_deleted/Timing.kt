/*
package com.example.navigationdemo.to_be_deleted

import com.example.navigationdemo.Navigation2
import java.util.*

class Timing(nav: Navigation2) :Thread() {
    */
/*var timeUp: Boolean by Delegates.observable(
        false,
    ){
        property, oldValue, newValue ->
        *//*
*/
/*run {
            Log.i("vals", "thread negated")
            Log.i("vals", "new val in thread:$timeUp")
        }*//*
*/
/*
    }*//*

    var timeUp : Boolean = false
    val refTimeUp = ::timeUp
    override fun run() {
        val init = Date()
        while(true){
            val diff: Long = Date().time - init.time
            sleep(50)
            if(diff >= 3000){
                timeUp = true

                return
            }
        }
    }
}*/
