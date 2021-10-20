package com.bytedance.dogadoption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cancel = findViewById<TextView>(R.id.cancel)
        cancel.setOnClickListener {
            finish()
        }
    }
}