package slenderloris.net.synthonaut

import android.media.AudioTrack

public class Feeder {

    private var thread : FeederThread? = null

    private val track: AudioTrack
    private val waver: Waver

    constructor(audioTrack : AudioTrack, waver : Waver) {
        this.track = audioTrack
        this.waver = waver
    }

    public fun start() {
        if(thread==null) {
            thread = FeederThread(track, waver)
            thread?.start()
        }
    }

    public fun stop() {
        thread?.stop()
        thread = null
    }

}