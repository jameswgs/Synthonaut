package slenderloris.net.synthonaut

import java.lang.Math

val audioFramesPerSecond441khz: Int = 44100

fun createNoiseArray(frame : Long, frequency : Double, amplitude : Double) : ShortArray {
    val shorts = ShortArray(1)
    val wavePoint = createNoise(frame, frequency, amplitude)
    shorts[0] = wavePoint.toShort()
    return shorts
}

fun createNoise(frame : Long, frequency : Double, amplitude : Double) : Double {
    if(frequency==0.0) return 0.0
    if(amplitude==0.0) return 0.0
    val secondMark = frame.toDouble() / audioFramesPerSecond441khz.toDouble()
    val waveMark = secondMark * frequency
    return createNoise(waveMark, amplitude)
}

fun createNoise(wavePoint : Double, amplitude: Double) : Double {
    if(amplitude==0.0) return 0.0
    return Math.sin(wavePoint * Math.PI * 2.0) * amplitude * Short.MAX_VALUE.toDouble()
}

fun nextWavePoint(wavePoint: Double, frequency: Double) : Double {
    return wavePoint + frequency / audioFramesPerSecond441khz.toDouble()
}