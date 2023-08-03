package com.ajayam.kotlinecoroutinesuspendingfunction

import android.content.ContentValues.TAG
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }

        CoroutineScope(Dispatchers.Main).launch {
            task2()
        }

    }


    suspend fun task1() {
        Log.d(TAG, "STARTING TASK 1")
        yield()
        Log.d(TAG, "ENDING TASK 1")
    }

    suspend fun task2() {
        Log.d(TAG, "STARTING TASK 2")
        yield()
        Log.d(TAG, "ENDING TAST 2")
    }

}

//RESULT TO UNDERSTAND

//2023-08-03 16:52:11.825  6871-6871  ContentValues           com...necoroutinesuspendingfunction  D  STARTING TASK 1
//2023-08-03 16:52:11.825  6871-6871  ContentValues           com...necoroutinesuspendingfunction  D  STARTING TASK 2
//2023-08-03 16:52:11.825  6871-6871  ContentValues           com...necoroutinesuspendingfunction  D  ENDING TASK 1
//2023-08-03 16:52:11.826  6871-6871  ContentValues           com...necoroutinesuspendingfunction  D  ENDING TAST 2