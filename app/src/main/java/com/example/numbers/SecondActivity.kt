package com.example.numbers

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import java.util.logging.Logger

class SecondActivity : Activity() {
    var number = 0
    var log = LoggerHelper.setupLogger(Logger.getLogger(this::class.java.name))
    companion object {
        val SECOND_ACTIVITY_NUMBER = "SECOND_ACTIVITY_NUMBER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        number = intent.getIntExtra(SECOND_ACTIVITY_NUMBER, 0)
        number *= number
        log.info("Activity 2 created")
        setContentView(R.layout.second_activity)
        findViewById<TextView>(R.id.act2View).text = number.toString()
    }

    override fun onStart() {
        super.onStart()
        log.info("Activity 2 started")
    }

    override fun onResume() {
        super.onResume()
        log.info("Activity 2 resumed")
    }

    override fun onPause() {
        super.onPause()
        log.info("Activity 2 paused")
    }

    override fun onStop() {
        super.onStop()
        log.info("Activity 2 stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        log.info("Activity 2 destroyed")
    }
}
