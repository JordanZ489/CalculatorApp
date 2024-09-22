package com.cs407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cs407.calculatorapp.R

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getDoubleExtra("result", 0.0)

        val tvResult = findViewById<TextView>(R.id.Result)
        tvResult.text = result.toString()
    }
}
