package slenderloris.net.synthonaut

import android.media.AudioTrack

public class FeederThread {

    private val buffer = ShortArray(1)
    private val thread: Thread

    private var go : Boolean = true

    public constructor(track : AudioTrack, waver: Waver) {
        val waitFrames = track.bufferSizeInFrames / 2
        val waitTime = ( 1000 * waitFrames / track.sampleRate ).toLong()
        thread = Thread() {
            while(go) {
                buffer[0] = waver.sample().toShort()
                if(track.write(buffer, 0, 1)==1) {
                    waver.next()
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