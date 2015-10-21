package slenderloris.net.synthonaut

import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    private val frameSize = 2
    private val framesInBuffer = 1 * audioFramesPerSecond441khz
    private val bufferSize = framesInBuffer * frameSize
    private val audioTrack: AudioTrack = AudioTrack(AudioManager.STREAM_MUSIC, audioFramesPerSecond441khz, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT, bufferSize, AudioTrack.MODE_STREAM)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun playSound(view : View) {
        audioTrack.pause()
        audioTrack.flush()
        for (i in 1..framesInBuffer) {
            val frame = i - 1
            val noise = createNoiseArray(frame.toLong(), 440.0, 1.0)
            val length = audioTrack.write(noise, 0, 1)
            if(length!=1) {
                Log.e("APP", "Error writing audio! length = $length at pos $i")
            }
        }
        audioTrack.play()
    }
}
