package com.nasiha.chatbot.utils

import com.nasiha.chatbot.utils.Constants.OPEN_GOOGLE
import com.nasiha.chatbot.utils.Constants.OPEN_SEARCH

object BotResponse {

    fun basicResponse(_message: String): String {
        val random = (0..2).random()
        val message = _message.toLowerCase()

        return when {
            message.contains("hello") -> {
                when (random) {
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "Hari Agus Widakdo"
                    else -> "Error"
                }
            }

            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks for asking!"
                    1 -> "I'm hungry"
                    2 -> "Pretty good! How about yout?"
                    else -> "Error"
                }
            }

            message.contains("flip") && message.contains("coin") -> {
                var random = (0..1).random()
                val result = if (random == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            message.contains("solve") -> {
                val equation: String? = message.substringAfter("solve")

                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    answer.toString()
                } catch (e: Exception) {
                    "Sorry, I can't solved that!"
                }
            }

            /**
             * Add questions name
             */
            message.contains("whats your name") -> {
                when (random) {
                    0 -> "My is Chat Bot"
                    else -> ""
                }
            }

            /**
             * Add questions old
             */
            message.contains("how are you old") -> {
                when (random) {
                    0 -> "18 old"
                    else -> ""
                }
            }

            message.contains("time") && message.contains("?") -> {
                Time.timeStamp()
            }

            message.contains("open") && message.contains("google") -> {
                OPEN_GOOGLE
            }

            message.contains("search") -> {
                OPEN_SEARCH
            }

            else -> {
                when (random) {
                    0 -> "I don't understand.."
                    1 -> "Idk"
                    2 -> "Try asking me something different!"
                    else -> "Error"
                }
            }
        }
    }
}