package com.example.testdrivendevelopmentapp

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class Car(
    var engine: Engine,
    var fuel: Double) {

    fun turnOn() {
        fuel -= 0.5
        CoroutineScope(Dispatchers.Main).launch {
            engine.turnOn().collect {
                // Log.d("TDD", "collected engine temperature: $it")
            }
        }
    }
}