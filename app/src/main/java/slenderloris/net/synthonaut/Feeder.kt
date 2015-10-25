package slenderloris.net.synthonaut

import android.media.AudioTrack

public class Feeder {

    private var thread : FeederThread? = null

    private val track: AudioTrack
    private val waveSource: WaveSource

    constructor(audioTrack : AudioTrack, oscillator: WaveSource) {
        this.track = audioTrack
        this.waveSource = oscillator
    }

    public fun start() {
        if(thread==null) {
            thread = FeederThread(track, waveSource)
            thread?.start()
        }
    }

    public fun stop() {
        thread?.stop()
        thread = null
    }

}

