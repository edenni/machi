package com.eden.machi.view

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.eden.machi.R
import kotlinx.android.synthetic.main.activity_walk.*

class WalkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walk)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
//        supportActionBar?.setDisplayShowHomeEnabled(true);

        // make status bar transparent
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        val hour: Int = intent.getIntExtra(EXTRA_DATA_HOUR, 0)
        val minute: Int = intent.getIntExtra(EXTRA_DATA_MINUTE, 0)
        Log.d(this.javaClass.name, "%d:%d".format(hour, minute))

        // TODO request ... (loading view)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === android.R.id.home) {

            Log.d("jjj", supportFragmentManager.fragments[0].toString())
            if (supportFragmentManager.fragments.javaClass == PhotoDetailFragment::class.java)
                supportFragmentManager.popBackStack()
            else
                finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_DATA_HOUR = "hour"
        const val EXTRA_DATA_MINUTE = "minute"
    }
}