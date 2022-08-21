package com.example.a08_22_subject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class CustomerActivity : AppCompatActivity() {

    private val finishButton:Button by lazy {
        findViewById(R.id.finishButton)
    }
    private val returnloginButton: Button by lazy {
        findViewById(R.id.returnLoginButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

        finishButton.setOnClickListener {
            Toast.makeText(this, "메인 메뉴로 이동", Toast.LENGTH_SHORT).show()
            finish()
        }
        returnloginButton.setOnClickListener {
            Toast.makeText(this, "로그인으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent()
            intent.putExtra("MULTI_FINISH", true)
            setResult(Activity.RESULT_OK, intent)
            this@CustomerActivity.finish()
        }
    }
}