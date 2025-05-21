package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val btnStart: Button = findViewById(R.id.btnStart) // I declared my variable
        btnStart.setOnClickListener {
            val intent = Intent(this, FlashcardActivity::class.java)
            startActivity(intent)
            //Author: OpenaiChatGPT
            // Url: https://chatgpt.com
        }
    }
}
