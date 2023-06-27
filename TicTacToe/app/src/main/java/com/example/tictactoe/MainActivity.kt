package com.example.tictactoe

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private var activePlayer : String = "x"
    private var playerType : Int =2

    private var gameState = arrayOf(2,2,2,2,2,2,2,2,2)
    private var winState = listOf(  listOf(0,1,2), listOf(3,4,5), listOf(6,7,8),
                                    listOf(0,3,6), listOf(1,4,7), listOf(2,5,8),
                                    listOf(0,4,8), listOf(2,4,6) )

    private var player1 = mutableListOf<Int>()
    private var player2 = mutableListOf<Int>()

    private var wonMatch : Boolean = false

    private var p1: String? = null
    private var p2:String?= null

    private var winner:Int? = null
    private var winnerString: String? = null

    private lateinit var player1Layout: LinearLayout
    private lateinit var player2Layout: LinearLayout
    private lateinit var p1TextView : TextView
    private lateinit var p2TextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        player1Layout = findViewById(R.id.linearLayout)
        player2Layout = findViewById(R.id.linearLayout2)



        player1Layout.background = ContextCompat.getDrawable(this@MainActivity, R.drawable.user_stroke)

        p1 = intent.getStringExtra("player1").toString()
        p2 = intent.getStringExtra("player2").toString()
        playerType = intent.getStringExtra("playerType").toString().toInt()

        p1TextView = findViewById(R.id.p1)
        p2TextView = findViewById(R.id.p2)

        p1TextView.text = p1.toString()
        p2TextView.text = p2.toString()

    }

    fun btnClicked(view: View){
        val idx = (view as ImageButton).tag.toString().toInt()
        if (gameState[idx] == 2){
            if (playerType == 1) {

                view.setImageResource(R.drawable.ximage)
                gameState[idx] = 0
                player1.add(idx)
                for (i in winState){
                    val cln = player1.intersect(i.toSet()).sorted()
                    if (cln == i){
                        Toast.makeText(this, "$p1 wins", Toast.LENGTH_SHORT).show()
                        winner =0
                        winnerString = "$p1 won the match!"
                        gameChanger()
                        wonMatch =true
                        break
                    }
                }
                if (2 !in gameState && !wonMatch){
                    winnerString = "Match Tied"
                    gameChanger()
                }

                if (winner != 0){
                    val remaining = arrayListOf<Int>()
                    for (i in gameState.indices){
                        if (gameState[i] == 2) {
                            remaining.add(i)
                        }
                    }
                    val p2idx = remaining.random()
                    gameState[p2idx] = 1
                    setO(p2idx)
                    player2.add(p2idx)

                    for (i in winState) {
                        val cln = player2.intersect(i.toSet()).sorted()
                        if (cln == i) {
                            Toast.makeText(this, "$p1 wins", Toast.LENGTH_SHORT).show()
                            winner = 1
                            winnerString = "$p2 won the match!"
                            gameChanger()
                            wonMatch = true
                            break
                        }
                    }
                }
            }

            else {
                activePlayer = when (activePlayer) {
                    "x" -> {
                        view.setImageResource(R.drawable.ximage)
                        gameState[idx] = 0
                        player1.add(idx)
                        for (i in winState){
                            val cln = player1.intersect(i.toSet()).sorted()
                            if (cln == i){
                                Toast.makeText(this, "$p1 wins", Toast.LENGTH_SHORT).show()
                                winner =0
                                winnerString = "$p1 won the match!"
                                gameChanger()
                                wonMatch =true
                                break
                            }
                        }
                        "o"
                    }

                    else -> {
                        view.setImageResource(R.drawable.oimage)
                        gameState[idx] = 1
                        player2.add(idx)
                        for (i in winState){
                            val cln = player2.intersect(i.toSet()).sorted()
                            if (cln == i ){
                                Toast.makeText(this, "$p2 wins", Toast.LENGTH_SHORT).show()
                                winner =1
                                winnerString = "$p2 won the match!"
                                gameChanger()
                                wonMatch = true
                                break
                            }
                        }
                        "x"
                    }
                }

                if (2 !in gameState && !wonMatch){
                    Toast.makeText(this, "Match Tied", Toast.LENGTH_SHORT).show()
                    winnerString = "Match Tied"
                    gameChanger()
                }
                else{
                    if (activePlayer == "x") {
                        player1Layout.setBackgroundResource(R.drawable.user_stroke)
                        player2Layout.setBackgroundResource(R.drawable.user)
                    }
                    else{
                        player2Layout.setBackgroundResource(R.drawable.user_stroke)
                        player1Layout.setBackgroundResource(R.drawable.user)
                    }
                }
            }

        }
    }

    private fun setO(p2idx: Int) {
        if (p2idx == 0){
            val buffer = findViewById<ImageButton>(R.id.b0)
            buffer.setImageResource(R.drawable.oimage)
        }
        else if (p2idx == 1){
            val buffer = findViewById<ImageButton>(R.id.b1)
            buffer.setImageResource(R.drawable.oimage)
        }
        else if (p2idx == 2){
            val buffer = findViewById<ImageButton>(R.id.b2)
            buffer.setImageResource(R.drawable.oimage)
        }
        else if (p2idx == 3){
            val buffer = findViewById<ImageButton>(R.id.b3)
            buffer.setImageResource(R.drawable.oimage)
        }
        else if (p2idx == 4){
            val buffer = findViewById<ImageButton>(R.id.b4)
            buffer.setImageResource(R.drawable.oimage)
        }
        else if (p2idx == 5){
            val buffer = findViewById<ImageButton>(R.id.b5)
            buffer.setImageResource(R.drawable.oimage)
        }
        else if (p2idx == 6){
            val buffer = findViewById<ImageButton>(R.id.b6)
            buffer.setImageResource(R.drawable.oimage)
        }
        else if (p2idx == 7){
            val buffer = findViewById<ImageButton>(R.id.b7)
            buffer.setImageResource(R.drawable.oimage)
        }
        else if (p2idx == 8){
            val buffer = findViewById<ImageButton>(R.id.b8)
            buffer.setImageResource(R.drawable.oimage)
        }
    }

    private fun gameChanger(){
        val alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle(winnerString)
            .setCancelable(false)
            .setPositiveButton("Reset Game", DialogInterface.OnClickListener { dialog, which ->
                gameState = arrayOf(2,2,2,2,2,2,2,2,2)
                player1.clear()
                player2.clear()
                activePlayer = "x"
                winner = null

                var imageButton : ImageButton = findViewById(R.id.b0)
                imageButton.setImageResource(R.drawable.btn)

                imageButton = findViewById(R.id.b1)
                imageButton.setImageResource(R.drawable.btn)

                imageButton = findViewById(R.id.b2)
                imageButton.setImageResource(R.drawable.btn)

                imageButton = findViewById(R.id.b3)
                imageButton.setImageResource(R.drawable.btn)

                imageButton = findViewById(R.id.b4)
                imageButton.setImageResource(R.drawable.btn)

                imageButton = findViewById(R.id.b5)
                imageButton.setImageResource(R.drawable.btn)

                imageButton = findViewById(R.id.b6)
                imageButton.setImageResource(R.drawable.btn)

                imageButton = findViewById(R.id.b7)
                imageButton.setImageResource(R.drawable.btn)

                imageButton = findViewById(R.id.b8)
                imageButton.setImageResource(R.drawable.btn)

                player1Layout.background = ContextCompat.getDrawable(this@MainActivity, R.drawable.user_stroke)
                player2Layout.background = ContextCompat.getDrawable(this@MainActivity, R.drawable.user)
            })
            .setNegativeButton("Home", DialogInterface.OnClickListener { dialog, which ->
                val i =Intent(this@MainActivity, HomeScreen::class.java)
                startActivity(i)
                finish()
            })
        alertDialog.create().show()
    }
}




