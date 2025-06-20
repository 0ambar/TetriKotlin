package com.example.tetrisgame

import android.content.Context
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class HighScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_score)
        
        // Configuración de pantalla completa y orientación
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        supportActionBar?.hide()

        val textHighScore = findViewById<TextView>(R.id.text_high_score_display)
        val buttonBack = findViewById<Button>(R.id.button_back_to_menu)

        // Mostrar el puntaje máximo
        val sharedPreference = getSharedPreferences("HIGH_SCORE", Context.MODE_PRIVATE)
        val highScore = sharedPreference.getInt("high_score", 0)
        textHighScore.text = highScore.toString()

        buttonBack.setOnClickListener {
            finish() // Regresar al menú principal
        }
    }
}
