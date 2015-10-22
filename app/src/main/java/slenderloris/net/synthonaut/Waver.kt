package slenderloris.net.synthonaut

class Waver() {

    public var amplitude: Double = 0.0
    public var frequency: Double = 0.0

    private var wavePoint : Double = 0.0

    public fun sample() : Double {
        val noise = createNoise(wavePoint, amplitude)
        return noise
    }

    public fun next() {
        wavePoint = nextWavePoint(wavePoint, frequency)
    }

}