package slenderloris.net.synthonaut

public class Value : WaveSource {

    public var value: Double

    constructor(value : Double) {
        this.value = value;
    }

    override fun getSample(): Double {
        return value
    }

    override fun next() {
    }

}