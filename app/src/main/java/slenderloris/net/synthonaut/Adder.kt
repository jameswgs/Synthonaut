package slenderloris.net.synthonaut

public class Adder : WaveSource {

    private var waveSource0: WaveSource
    private var waveSource1: WaveSource

    public constructor(waveSource0: WaveSource, waveSource1: WaveSource) {
        this.waveSource0 = waveSource0
        this.waveSource1 = waveSource1
    }

    override fun getSample(): Double {
        return waveSource0.getSample() + waveSource1.getSample()
    }

    override fun next() {
        waveSource0.next()
        waveSource1.next()
    }

}