package com.example.testdrivendevelopmentapp.acceptanceTests


import com.example.testdrivendevelopmentapp.Car
import com.example.testdrivendevelopmentapp.Engine
import com.example.testdrivendevelopmentapp.utils.MainCoroutineScopeRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CarFeature {

    private val engine = Engine()
    private val car = Car(engine, 6.0)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(5.5, car.fuel, 0.0)
    }

    @Test
    fun carIncreasesTheTemperatureGraduallyWhenTurnsTheEngineOn() {
        car.turnOn()

        coroutinesTestRule.advanceTimeBy(2000)
        assertEquals(25, car.engine.temperature)
        coroutinesTestRule.advanceTimeBy(2000)
        assertEquals(50, car.engine.temperature)
        coroutinesTestRule.advanceTimeBy(2000)
        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }

}