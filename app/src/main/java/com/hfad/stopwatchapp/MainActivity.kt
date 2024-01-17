package com.hfad.stopwatchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {
    lateinit var stopWatch: Chronometer
    var running = false
    var offset: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stopWatch = findViewById<Chronometer>(R.id.stopWatch)
        val startButton = findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener {
            if (!running) {
                setBaseTime()
                stopWatch.start()
                running = true
            }
        }
        val pauseButton = findViewById<Button>(R.id.pause_button)
        pauseButton.setOnClickListener {
            if (running){
                saveOffset()
                stopWatch.stop()
                running = false
            }
        }
        val resetButton = findViewById<Button>(R.id.reset_button)
        resetButton.setOnClickListener {
            offset = 0
            setBaseTime()
        }

    }
    fun setBaseTime(){
        stopWatch.base = SystemClock.elapsedRealtime() - offset
    }

    fun saveOffset() {
        offset = SystemClock.elapsedRealtime() - stopWatch.base
    }

}