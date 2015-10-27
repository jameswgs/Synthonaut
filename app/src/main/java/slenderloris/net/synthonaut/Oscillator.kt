package slenderloris.net.synthonaut

class Oscillator() : WaveSource {

    public var frequency: Double = 0.0

    private var wavePoint : Double = 0.0

    override fun getSample() : Double {
        val noise = createNoise(wavePoint)
        return noise
    }

    override fun next() {
        wavePoint = nextWavePoint(wavePoint, frequency)
    }

    fun nextWavePoint(wavePoint: Double, frequency: Double) : Double {
        return wavePoint + frequency / audioFramesPerSecond441khz.toDouble()
    }

    fun createNoise(wavePoint : Double) : Double {
        return Math.sin(wavePoint * Math.PI * 2.0) * Short.MAX_VALUE.toDouble()
    }

}
