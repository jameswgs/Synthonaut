package slenderloris.net.synthonaut

import org.junit.Test

import org.junit.Assert.*

class NoiserTest {

    private val fps = 44100L

    @Test
    @Throws(Exception::class)
    fun testReturnsWaveform() {
        val expected = (Math.sin(0.5 * Math.PI * 2.0) * Short.MAX_VALUE.toDouble()).toShort()
        assertEquals(expected, createNoiseArray(fps/2, 1.0, 1.0)[0]);
    }

    @Test
    fun canCreate2HzWave() {
        val expected = Math.sin(1.0 * Math.PI * 2.0)
        assertEquals(expected, createNoise(fps/2, 2.0, 1.0), 0.0000001);
    }

    @Test
    fun canCreate1HzWaveAtDoubleAmplitude() {
        val expected = Math.sin(0.5 * Math.PI * 2.0) * 2.0
        assertEquals(expected, createNoise(fps/2, 1.0, 2.0), 0.0000001);
    }

}