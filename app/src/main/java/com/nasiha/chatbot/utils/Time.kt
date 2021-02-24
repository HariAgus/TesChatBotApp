package com.nasiha.chatbot.utils

import android.annotation.SuppressLint
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object Time {

    @SuppressLint("SimpleDateFormat")
    fun timeStamp(): String {
        val timeStamp = Timestamp(System.currentTimeMillis())
        val simpleDatFormat = SimpleDateFormat("HH:mm")
        val time = simpleDatFormat.format(Date(timeStamp.time))

        return time.toString()
    }

}