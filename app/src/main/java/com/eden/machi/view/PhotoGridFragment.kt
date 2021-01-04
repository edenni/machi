package com.eden.machi.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eden.machi.viewmodel.PhotoGridViewModel
import com.eden.machi.R

class PhotoGridFragment : Fragment() {

    companion object {
        fun newInstance() = PhotoGridFragment()
    }

    private lateinit var viewModel: PhotoGridViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        val binding = FragmentPhoto.inflate(inflater)
        return inflater.inflate(R.layout.photo_grid_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PhotoGridViewModel::class.java)

    }

}