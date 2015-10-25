package slenderloris.net.synthonaut

import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import android.view.View

class MainActivity : AppCompatActivity {

    private val frameSize = 2
    private val framesInBuffer = audioFramesPerSecond441khz / 100
    private val bufferSize = framesInBuffer * frameSize
    private val audioTrack = AudioTrack(AudioManager.STREAM_MUSIC, audioFramesPerSecond441khz, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT, bufferSize, AudioTrack.MODE_STREAM)

    private val oscillator : Oscillator
    private val multiplier: Multiplier
    private val feeder : Feeder

    public constructor() {
        oscillator = Oscillator()
        multiplier = Multiplier(oscillator)
        // todo add adder
        feeder = Feeder(audioTrack, multiplier)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun start() {
        stop()
        multiplier.multiplier = 0.8
        oscillator.frequency = 440.0
        feeder.start()
        audioTrack.play()
    }

    private fun stop() {
        audioTrack.pause()
        audioTrack.flush()
        feeder.stop()
    }




    private var touchX = 0.0f
    private var touchY = 0.0f

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event!=null) {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> touchDown(event.x, event.y)
                MotionEvent.ACTION_MOVE -> touchMove(event.x, event.y)
                MotionEvent.ACTION_UP -> stop()
                MotionEvent.ACTION_CANCEL -> stop()
            }
        }
        return true
    }

    private fun touchMove(x: Float, y: Float) {
        oscillator.frequency += ( x - touchX )
        multiplier.multiplier += ( y - touchY ) / 1000
        multiplier.multiplier = Math.min(1.0, multiplier.multiplier)
        multiplier.multiplier = Math.max(0.0, multiplier.multiplier)
        touchX = x
        touchY = y
    }

    private fun touchDown(x: Float, y: Float) {
        start()
        touchX = x
        touchY = y
    }

}
