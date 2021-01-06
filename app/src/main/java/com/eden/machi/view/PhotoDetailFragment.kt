package com.eden.machi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.eden.machi.databinding.FragmentPhotoDetailBinding
import com.eden.machi.viewmodel.PhotoDetailViewModel
import com.eden.machi.viewmodel.PhotoDetailViewModelFactory
import kotlinx.android.synthetic.main.activity_walk.*

class PhotoDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().title = "Detail"
        val application = requireNotNull(activity).application
        val binding = FragmentPhotoDetailBinding.inflate(inflater)

        binding.lifecycleOwner = this
        val streetImageProperty = PhotoDetailFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = PhotoDetailViewModelFactory(streetImageProperty, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(PhotoDetailViewModel::class.java)

        return binding.root
    }


}