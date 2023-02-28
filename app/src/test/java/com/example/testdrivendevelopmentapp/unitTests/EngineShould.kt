package com.example.testdrivendevelopmentapp.unitTests

import com.example.testdrivendevelopmentapp.Engine
import com.example.testdrivendevelopmentapp.utils.MainCoroutineScopeRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class EngineShould {

    private val engine = Engine()

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()


    @Test
    fun turnOn() = runTest {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTemperatureGraduallyWhenItTurnsOn() = runTest {
        val flow = engine.turnOn()
        val actual = flow.toList()

        assertEquals(listOf(25, 50, 95), actual)
    }
}