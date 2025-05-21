package com.example.flashcardapp

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)
        val questions = intent.getStringArrayExtra("questions") ?: arrayOf()
        val answers = intent.getBooleanArrayExtra("answers") ?: booleanArrayOf()

        val tvScore: TextView = findViewById(R.id.tvScore)
        val tvFeedback: TextView = findViewById(R.id.tvFeedback)
        val btnReview: Button = findViewById(R.id.btnReview)
        val btnExit: Button = findViewById(R.id.btnExit)

        tvScore.text = "You got $score out of ${questions.size}"
        tvFeedback.text = if (score >= 3) "🎉 Great job!" else "📚 Keep practising!"
        //Author: OpenaiChatGPT
        // Url: https://chatgpt.com

        btnReview.setOnClickListener {
            val reviewText = questions.indices.joinToString("\n") {
                "${questions[it]} - Answer: ${if (answers[it]) "True" else "False"}"
            }

            AlertDialog.Builder(this)
                .setTitle("Review Answers")
                .setMessage(reviewText)
                .setPositiveButton("OK", null)
                .show()
            //Author: OpenaiChatGPT
            // Url: https://chatgpt.com
        }

        btnExit.setOnClickListener {
            finishAffinity()  // This is to close the  app
        }
    }
}
