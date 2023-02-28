package com.example.testdrivendevelopmentapp.unitTests

import com.example.testdrivendevelopmentapp.Engine
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*


@OptIn(ExperimentalCoroutinesApi::class)
class EngineTest {

    //private val engine = Engine(2000, 189, 15, false)
    private val engine = Engine()

    @Test
    fun engineTurnsOn() = runTest {
        engine.turnOn()

        assertEquals(true, engine.isTurnedOn)
        //assertEquals(95, engine.temperature)
    }

    @Test
    fun engineTurnsOff() {
        engine.turnOff()

        assertEquals(false, engine.isTurnedOn)
        //assertEquals(15, engine.temperature)
    }
}