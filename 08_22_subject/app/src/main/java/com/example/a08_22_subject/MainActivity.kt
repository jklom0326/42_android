package com.example.a08_22_subject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private val loginButton: Button by lazy {
        findViewById(R.id.loginButton)
    }
    private val idEditTextView: EditText by lazy {
        findViewById(R.id.idEditText)
    }
    private lateinit var passwordEditText: EditText
    private lateinit var getResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        passwordEditText = findViewById(R.id.passwordEditText)
        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode != RESULT_OK) {
                return@registerForActivityResult
            }
        }


        loginButton.setOnClickListener {
            if (idEditTextView.text.isEmpty() || passwordEditText.text.isEmpty()) {
                Toast.makeText(this, "아이디와 비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                val intent = Intent(this, MenuActivity::class.java)
                getResult.launch(intent)
            }
        }
    }
}
