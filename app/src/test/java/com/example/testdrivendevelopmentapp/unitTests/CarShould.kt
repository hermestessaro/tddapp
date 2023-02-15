package com.example.testdrivendevelopmentapp.unitTests

import com.example.testdrivendevelopmentapp.Car
import com.example.testdrivendevelopmentapp.Engine
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Test

class CarShould {

    private val engine: Engine = mock()
    private val car = Car(engine, 5.0)

    @Test
    fun loseFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(4.5, car.fuel, 0.0)
    }

    @Test
    fun turnOnItsEngine() {
        car.turnOn()

        //verifies that in the "engine" mock the method turnOn has been called once
        verify(engine, times(1)).turnOn()
    }

}