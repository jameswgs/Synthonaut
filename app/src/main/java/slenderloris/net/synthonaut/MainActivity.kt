package slenderloris.net.synthonaut

import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

private val frameSize = 441 * 2 * 2


class MainActivity : AppCompatActivity() {

    private val audioTrack: AudioTrack = AudioTrack(AudioManager.STREAM_MUSIC, 44100, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT, frameSize, AudioTrack.MODE_STREAM)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun playSound(view : View) {
        val go = true;
        var t = Thread() {
            audioTrack.write()
        }
    }
}
