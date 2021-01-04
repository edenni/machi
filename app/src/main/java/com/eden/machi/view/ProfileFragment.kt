package com.eden.machi

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // change status bar text color
        // may use `WindowInsetsController` for api 30
        // https://developer.android.com/reference/kotlin/android/view/WindowInsetsController?hl=ja
        val decorView: View? = activity?.window?.decorView //set status background black
        decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN.inv() and
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


}