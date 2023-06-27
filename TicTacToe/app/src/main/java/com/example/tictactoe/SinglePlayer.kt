package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SinglePlayer : AppCompatActivity() {

    private lateinit var player: EditText
    private lateinit var playBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_player)

        player = findViewById(R.id.player)
        playBtn = findViewById(R.id.play)

        playBtn.setOnClickListener {
            if (player.text.isNotEmpty()) {

                val i = Intent(this, MainActivity::class.java)
                i.putExtra("player1", player.text.toString())
                i.putExtra("player2", "Computer")
                i.putExtra("playerType", "1")
                startActivity(i)
                finish()
            } else {
                Toast.makeText(this, "Enter the player name.", Toast.LENGTH_LONG).show()
            }
        }

    }
}