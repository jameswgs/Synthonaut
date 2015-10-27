package slenderloris.net.synthonaut

class Multiplier : WaveSource {

    private val waveSource: WaveSource
    private var multiplier: WaveSource

    public constructor(waveSource: WaveSource, multiplier: WaveSource) {
        this.waveSource = waveSource
        this.multiplier = multiplier
    }

    override fun getSample(): Double {
        return waveSource.getSample() * multiplier.getSample()
    }

    override fun next() {
        waveSource.next()
        multiplier.next()
    }

}