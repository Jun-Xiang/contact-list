package com.khayrul.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val greetings = GreetingsImpl2()
//        greetings.sayHello()
    }
}

//interface Greetings {
//    fun sayHello()
//}
//
//class GreetingsImpl: Greetings {
//    override fun sayHello() {
//        Log.d("MainActivity", "Hello from GreetingsImpl")
//    }
//}
//
//class GreetingsImpl2: Greetings by GreetingsImpl() {
//    override fun sayHello() {
//        Log.d("MainActivity", "Hello from GreetingsImpl2")
//    }
//    fun sayHello2() {
//
//    }
//}

