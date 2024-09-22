package com.cs407.calculatorapp

import android.content.Intent
import android.media.VolumeShaper.Operation
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etFirstNumber = findViewById<EditText>(R.id.etFirstNumber)
        val etSecondNumber = findViewById<EditText>(R.id.etSecondNumber)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        btnAdd.setOnClickListener {
            performOperation(etFirstNumber, etSecondNumber, "add")
        }

        btnSubtract.setOnClickListener {
            performOperation(etFirstNumber, etSecondNumber, "subtract")
        }

        btnMultiply.setOnClickListener {
            performOperation(etFirstNumber, etSecondNumber, "multiply")
        }

        btnDivide.setOnClickListener {
            performOperation(etFirstNumber, etSecondNumber, "divide")
        }

    }

    fun performOperation(etFirstNumber: EditText, etSecondNumber: EditText, operation: String){
        val number1 = etFirstNumber.text.toString()
        val number2 = etSecondNumber.text.toString()

        if (number1.isEmpty() || number2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = number1.toDouble()
        val num2 = number2.toDouble()
        var result = 0.0

        when (operation) {
            "add" -> result = num1 + num2
            "subtract" -> result = num1 - num2
            "multiply" -> result = num1 * num2
            "divide" -> {
                if (num2 == 0.0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
                result = num1 / num2
            }
        }
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }
}



