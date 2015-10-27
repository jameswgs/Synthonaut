package slenderloris.net.synthonaut

class Multiplier : WaveSource {

    private val waveSource: WaveSource

    public var multiplier = 1.0

    public constructor(waveSource: WaveSource) {
        this.waveSource  = waveSource
    }

    override fun getSample(): Double {
        if(multiplier==0.0) return 0.0
        return waveSource.getSample() * multiplier
    }

    override fun next() {
        waveSource.next()
    }

}