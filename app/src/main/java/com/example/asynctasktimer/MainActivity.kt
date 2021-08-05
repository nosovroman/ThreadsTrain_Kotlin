package com.example.asynctasktimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var startButton : Button
    private lateinit var stopButton : Button
    private lateinit var counterTV : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initElements()

        val thread = Thread (Runnable {
            for (i in 0..10) {
                runOnUiThread(Runnable {
                    counterTV.text = i.toString()
                })
                Thread.sleep(1000)
            }
        })
        thread.start()
    }

    private fun initElements() {
        startButton = findViewById(R.id.startBtn)
        stopButton = findViewById(R.id.endBtn)
        counterTV = findViewById(R.id.counter)
    }
}