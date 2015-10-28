package slenderloris.net.synthonaut

public class FrequencyModulator : WaveSource {

    private var oscilator: Oscillator
    private var modulator: WaveSource

    public constructor(osclilator : Oscillator, modulator : WaveSource) {
        this.oscilator = osclilator
        this.modulator = modulator
    }

    override fun getSample(): Double {
        oscilator.frequency = modulator.getSample()
        return oscilator.getSample()
    }

    override fun next() {
        oscilator.next()
        modulator.next()
    }


}