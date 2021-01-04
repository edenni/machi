package com.eden.machi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import com.eden.machi.R

class WalkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walk)

        // make status bar transparent
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        val hour: Int = intent.getIntExtra(EXTRA_DATA_HOUR, 0)
        val minute: Int = intent.getIntExtra(EXTRA_DATA_MINUTE, 0)
        Log.d(this.javaClass.name, "%d:%d".format(hour, minute))

        // TODO request ... (loading view)


    }

    companion object {
        const val EXTRA_DATA_HOUR = "hour"
        const val EXTRA_DATA_MINUTE = "minute"
    }
}