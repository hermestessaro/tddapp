package com.example.testdrivendevelopmentapp.unitTests

import com.example.testdrivendevelopmentapp.Car
import com.example.testdrivendevelopmentapp.Engine
import com.example.testdrivendevelopmentapp.utils.MainCoroutineScopeRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CarShould {

    private val engine: Engine = mock()
    private val car : Car

    init {
        runTest {
            whenever(engine.turnOn()).thenReturn(flow {
                emit(25)
                emit(50)
                emit(95)
            })
        }
        car = Car(engine, 5.0)
    }

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun loseFuelWhenItTurnsOn() = runTest {
        car.turnOn()

        assertEquals(4.5, car.fuel, 0.0)
    }

    @Test
    fun turnOnItsEngine() = runTest {
        car.turnOn()

        //verifies that in the "engine" mock the method turnOn has been called once
        verify(engine, times(1)).turnOn()
    }

}