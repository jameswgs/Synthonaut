package slenderloris.net.synthonaut

class Waver() {

    private var amplitude: Double = 0.0
    private var frequency: Double = 0.0
    private var frame : Long = 0

    public fun nextSample() : Double {
        return createNoise(frame, frequency, amplitude)
    }


}