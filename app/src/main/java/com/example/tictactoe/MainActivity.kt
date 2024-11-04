package com.example.tictactoe

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var gameStatus: TextView
    private lateinit var gridLayout: GridLayout
    private lateinit var restartButton: Button
    private var currentPlayer = "X"
    private var board = Array(3) { Array(3) { "" } }
    private var gameActive = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameStatus = findViewById(R.id.tvStatus)
        gridLayout = findViewById(R.id.gridLayout)
        restartButton = findViewById(R.id.btnRestart)

        setupBoard()

        restartButton.setOnClickListener {
            resetGame()
        }
    }

    private fun setupBoard() {
        for (i in 0 until gridLayout.childCount) {
            val button = gridLayout.getChildAt(i) as Button
            button.setOnClickListener {
                if (button.text == "" && gameActive) {
                    button.text = currentPlayer
                    val row = i / 3
                    val col = i % 3
                    board[row][col] = currentPlayer
                    if (checkWinner()) {
                        gameStatus.text = "Jogador $currentPlayer venceu!"
                        gameActive = false
                    } else if (isBoardFull()) {
                        gameStatus.text = "Empate!"
                        gameActive = false
                    } else {
                        currentPlayer = if (currentPlayer == "X") "O" else "X"
                        gameStatus.text = "Jogador $currentPlayer, sua vez"
                    }
                }
            }
        }
    }

    private fun checkWinner(): Boolean {
        // Verifica linhas, colunas e diagonais
        for (i in 0..2) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true
        }
        return false
    }

    private fun isBoardFull(): Boolean {
        for (row in board) {
            if (row.contains("")) {
                return false
            }
        }
        return true
    }

    private fun resetGame() {
        currentPlayer = "X"
        gameStatus.text = "Jogador X, sua vez"
        gameActive = true
        board = Array(3) { Array(3) { "" } }
        for (i in 0 until gridLayout.childCount) {
            val button = gridLayout.getChildAt(i) as Button
            button.text = ""
        }
    }
}