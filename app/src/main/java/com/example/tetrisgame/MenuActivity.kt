package com.example.tetrisgame

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        
        // Configuración de pantalla completa y orientación
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        supportActionBar?.hide()

        val buttonStartGame = findViewById<Button>(R.id.button_start_game)
        val buttonHighScore = findViewById<Button>(R.id.button_high_score)
        val textHighScore = findViewById<TextView>(R.id.text_high_score_value)

        // Mostrar el puntaje máximo actual
        updateHighScoreDisplay(textHighScore)

        buttonStartGame.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonHighScore.setOnClickListener {
            val intent = Intent(this, HighScoreActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Actualizar el puntaje máximo cuando regresemos a esta pantalla
        val textHighScore = findViewById<TextView>(R.id.text_high_score_value)
        updateHighScoreDisplay(textHighScore)
    }

    private fun updateHighScoreDisplay(textView: TextView) {
        val sharedPreference = getSharedPreferences("HIGH_SCORE", Context.MODE_PRIVATE)
        val highScore = sharedPreference.getInt("high_score", 0)
        textView.text = "Mejor Puntaje: $highScore"
    }
}
