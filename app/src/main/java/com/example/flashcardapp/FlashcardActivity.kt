package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FlashcardActivity : AppCompatActivity() {

    private lateinit var tvQuestion: TextView
    private lateinit var tvFeedback: TextView
    private var currentIndex = 0
    private var score = 0

    // These are the questions of the flashcards and answers
    private val questions = arrayOf(
        "The Great Wall of China is visible from space.",
        "The Declaration of Independence was signed in 1776.",
        "Napoleon Bonaparte was exiled to Elba in 1814.",
        "The Cold War ended in 1991.",
        "Julius Caesar was the first emperor of Rome."
    )

    private val answers = arrayOf(false, true, true, true, false)
    //Author: OpenaiChatGPT
    // Url: https://chatgpt.com

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)

        tvQuestion = findViewById(R.id.tvQuestion)
        tvFeedback = findViewById(R.id.tvFeedback)
        val btnTrue: Button = findViewById(R.id.btnTrue)
        val btnFalse: Button = findViewById(R.id.btnFalse)
        val btnNext: Button = findViewById(R.id.btnNext)

        loadQuestion()

        btnTrue.setOnClickListener { checkAnswer(true) }
        btnFalse.setOnClickListener { checkAnswer(false) }

        btnNext.setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                loadQuestion()
            } else {
                // Move to Score screen
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion() {
        tvQuestion.text = questions[currentIndex]
        tvFeedback.text = ""
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[currentIndex]) {
            score++
            tvFeedback.text = "✅ Correct!"
        } else {
            tvFeedback.text = "❌ Incorrect"
            //Author: OpenaiChatGPT
            // Url: https://chatgpt.com
        }
    }
}
