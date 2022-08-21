package com.example.a08_22_subject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MenuActivity : AppCompatActivity() {
    private val customerButton: Button by lazy {
        findViewById(R.id.manageCustomerButton)
    }
    private val salesButton: Button by lazy {
        findViewById(R.id.manageSalesButton)
    }
    private val productsButton: Button by lazy {
        findViewById(R.id.manageProductsButton)
    }
    private lateinit var getResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                it.data?.let {
                    if (it.getBooleanExtra("MULTI_FINISH", false)){
                        this@MenuActivity.finish()
                    }
                }
            }
        }

        customerButton.setOnClickListener {
            Toast.makeText(this, "고객관리 액티비티로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CustomerActivity::class.java)
            getResult.launch(intent)
        }
        salesButton.setOnClickListener {
            Toast.makeText(this, "매출관리 액티비티로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SalesActivity::class.java)
            getResult.launch(intent)
        }
        productsButton.setOnClickListener {
            Toast.makeText(this, "상품관리 액티비티로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ProductsActivity::class.java)
            getResult.launch(intent)
        }
    }
}