package com.example.numbers

import android.os.Environment
import java.io.IOException
import java.util.logging.FileHandler
import java.util.logging.Logger
import java.util.logging.SimpleFormatter

object LoggerHelper {
    fun setupLogger(log: Logger): Logger {
        val fileName: String = Environment.getExternalStorageDirectory().path + "/" + "log.txt"
        try {
            val fh = FileHandler(fileName)
            log.addHandler(fh)
            val formatter = SimpleFormatter()
            fh.formatter = formatter
        } catch (e: SecurityException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return log
    }
}
