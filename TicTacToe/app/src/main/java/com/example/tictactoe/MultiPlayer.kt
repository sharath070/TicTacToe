package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MultiPlayer : AppCompatActivity() {

    private lateinit var player1: EditText
    private lateinit var player2: EditText
    private lateinit var playBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_player)

        player1 = findViewById(R.id.p1)
        player2 = findViewById(R.id.p2)
        playBtn = findViewById(R.id.play)

        playBtn.setOnClickListener{
            if(player1.text.isNotEmpty() && player2.text.isNotEmpty()){

                val i = Intent(this, MainActivity::class.java)
                i.putExtra("player1", player1.text.toString())
                i.putExtra("player2", player2.text.toString())
                i.putExtra("playerType", "2")
                startActivity(i)
                finish()
            }
            else{
                Toast.makeText(this, "Fill the players name.", Toast.LENGTH_LONG).show()
            }
        }


    }
}