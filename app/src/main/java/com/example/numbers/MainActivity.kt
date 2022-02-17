package com.example.numbers

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.*
import java.util.logging.Logger

class MainActivity : Activity() {
    private val log = LoggerHelper.setupLogger(Logger.getLogger(this::class.java.name))
    private var number = 0;
    companion object {
        private val NUMBER_KEY = "NUMBER_SAVE_KEY"
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Objects.nonNull(savedInstanceState)) {
            number = savedInstanceState!!.getInt(NUMBER_KEY)
            number += 1
        }
        log.info("Activity 1 created")
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.act1View)
        text.text = number.toString()
        findViewById<TextView>(R.id.act1Action).setOnClickListener { startSecondActivity() }
    }

    override fun onStart() {
        super.onStart()
        log.info("Activity 1 started")
    }

    override fun onResume() {
        super.onResume()
        log.info("Activity 1 resumed")
    }

    override fun onPause() {
        super.onPause()
        log.info("Activity 1 paused")
    }

    override fun onStop() {
        super.onStop()
        log.info("Activity 1 stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        log.info("Activity 1 destroyed")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(NUMBER_KEY, number)
        super.onSaveInstanceState(outState)
        log.info("Activity 1 saved state $number")
    }

    private fun startSecondActivity() {
        val sendIntent = Intent(this,
            SecondActivity::class.java).apply {
                val bundle = Bundle().apply { putInt(SecondActivity.SECOND_ACTIVITY_NUMBER, number) }
                putExtras(bundle)
            }
        startActivity(sendIntent)
    }
}
