package com.example.tetrisgame

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class GameOverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
        
        // Configuración de pantalla completa y orientación
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        supportActionBar?.hide()

        val textFinalScore = findViewById<TextView>(R.id.text_final_score)
        val textHighScore = findViewById<TextView>(R.id.text_high_score_game_over)
        val textNewRecord = findViewById<TextView>(R.id.text_new_record)
        val buttonPlayAgain = findViewById<Button>(R.id.button_play_again)
        val buttonMenu = findViewById<Button>(R.id.button_back_to_menu_game_over)

        // Obtener el puntaje final del intent
        val finalScore = intent.getIntExtra("FINAL_SCORE", 0)
        val isNewRecord = intent.getBooleanExtra("IS_NEW_RECORD", false)

        // Mostrar el puntaje final
        textFinalScore.text = finalScore.toString()

        // Mostrar el puntaje máximo actual
        val sharedPreference = getSharedPreferences("HIGH_SCORE", Context.MODE_PRIVATE)
        val highScore = sharedPreference.getInt("high_score", 0)
        textHighScore.text = "Mejor: $highScore"

        // Mostrar mensaje de nuevo récord si aplica
        if (isNewRecord) {
            textNewRecord.visibility = View.VISIBLE
        } else {
            textNewRecord.visibility = View.GONE
        }

        buttonPlayAgain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        // Evitar que el usuario regrese al juego con el botón atrás
        val intent = Intent(this, MenuActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}
