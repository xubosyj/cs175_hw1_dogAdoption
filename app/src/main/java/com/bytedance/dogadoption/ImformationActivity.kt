package com.bytedance.dogadoption

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ImformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imformation)

        var tv = findViewById<TextView>(R.id.imfo)
        var img = findViewById<ImageView>(R.id.img)


        tv.text = intent.getStringExtra("dogImformation")
        img.setImageResource(intent.getIntExtra("dogImage", 0))



    }
}