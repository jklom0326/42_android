package com.example.android_42_1

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        Log.d(TAG, "1st=" + (context1))
        Log.d(TAG, "2nd=" + (context2))
        Log.d(TAG, "3rd=" + (context3))
        Log.d(TAG, "4th=" + (context4))
    }
}