package com.umut.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button_enter)
        val editText = findViewById<EditText>(R.id.edit_number)
        val statusText = findViewById<TextView>(R.id.text_info)
        val counterText = findViewById<TextView>(R.id.text_counter)
        var userInput = 0
        var chances = 5

        val answer = (1..100).random()

        button.setOnClickListener {
            if (editText.text.toString().toIntOrNull() != null) {
                userInput = Integer.parseInt(editText.text.toString())
            }

            if (userInput != answer) {
                if (userInput < answer){
                    statusText.text = getString(R.string.higher_number_text)
                }
                else{
                    statusText.text = getString(R.string.lower_number_text)
                }
                chances--
                counterText.text = getString(R.string.counter_text, chances)
                if (chances == 0) {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("status", "You Lost")
                    intent.putExtra("answer", answer)
                    intent.putExtra("chances", chances)
                    startActivity(intent)
                    finish()
                }
            }
            else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("status", "You Won")
                intent.putExtra("answer", answer)
                intent.putExtra("chances", chances)
                startActivity(intent)
                finish()
            }
        }
    }
}