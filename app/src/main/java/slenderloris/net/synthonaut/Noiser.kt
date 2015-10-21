package slenderloris.net.synthonaut

import java.lang.Math

val audioFramesPerSecond441khz: Int = 44100

fun createNoiseArray(frame : Long, frequency : Double, amplitude : Double) : ShortArray {
    val shorts = ShortArray(1)
    val wavePoint = createNoise(frame, frequency, amplitude)  * Short.MAX_VALUE.toDouble()
    shorts[0] = wavePoint.toShort()
    return shorts
}

fun createNoise(frame : Long, frequency : Double, amplitude : Double) : Double {
    val secondMark = frame.toDouble() / audioFramesPerSecond441khz.toDouble()
    val waveMark = secondMark * frequency
    return Math.sin(waveMark * Math.PI * 2.0) * amplitude
}
