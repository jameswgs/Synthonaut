package slenderloris.net.synthonaut

import android.media.AudioTrack

public class FeederThread {

    private val buffer = ShortArray(1)
    private val thread: Thread

    private var go : Boolean = true

    public constructor(track : AudioTrack, waveSource: WaveSource) {
        val waitFrames = track.bufferSizeInFrames / 2
        val waitTime = ( 1000 * waitFrames / track.sampleRate ).toLong()
        thread = Thread() {
            while(go) {
                buffer[0] = waveSource.getSample().toShort()
                if(track.write(buffer, 0, 1)==1) {
                    waveSource.next()
                }
                else {
                    Thread.sleep(waitTime)
                }
            }
        }
    }

    fun start() {
        thread.start()
    }

    fun stop() {
        go = false
    }

}