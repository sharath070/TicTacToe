package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeScreen : AppCompatActivity() {

    private lateinit var singlePlayer: Button
    private lateinit var multiPlayer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        singlePlayer = findViewById(R.id.sp)
        multiPlayer = findViewById(R.id.mp)

        singlePlayer.setOnClickListener{
            val intent = Intent(this, SinglePlayer::class.java)
            startActivity(intent)
        }

        multiPlayer.setOnClickListener{
            val intent = Intent(this, MultiPlayer::class.java)
            startActivity(intent)
        }

    }
}