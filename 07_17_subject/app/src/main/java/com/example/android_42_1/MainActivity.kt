package com.example.android_42_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view = findViewById<TextView>(R.id.textView)

        val context1 = (view.context == this) // 1
        val context2 = (view.context == baseContext) // 2
        val context3 = (view.context == applicationContext) // 3
        val context4 = (view.context == application) // 4

        println(context1)
        println(context2)
        println(context3)
        println(context4)
    }
}