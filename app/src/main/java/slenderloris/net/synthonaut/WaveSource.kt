package slenderloris.net.synthonaut

interface WaveSource {
    fun getSample() : Double
    fun next()
}
