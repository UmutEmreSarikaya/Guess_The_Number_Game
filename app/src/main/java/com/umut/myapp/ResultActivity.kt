package com.umut.myapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textSuccess = findViewById<TextView>(R.id.text_status)
        val textCounter = findViewById<TextView>(R.id.text_show_counter)
        val buttonPlay = findViewById<Button>(R.id.button_play)
        val layout = findViewById<ConstraintLayout>(R.id.layout)

        val text = intent.getStringExtra("status")
        val answer = intent.getIntExtra("answer", -1)
        val counter = intent.getIntExtra("chances", -1)

        textSuccess.text = text

        if (counter > 0) {
            layout.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.win_green))
            textCounter.text = getString(R.string.win_text, answer, counter)
        } else {
            layout.setBackgroundColor(Color.RED)
            textCounter.text = getString(R.string.lose_text, answer)
        }

        buttonPlay.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}