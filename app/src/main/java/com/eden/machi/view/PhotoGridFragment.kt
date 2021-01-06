package com.eden.machi.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.eden.machi.viewmodel.PhotoGridViewModel
import com.eden.machi.adapter.PhotoGridAdapter
import com.eden.machi.databinding.FragmentPhotoGridBinding

class PhotoGridFragment : Fragment() {

    private val viewModel: PhotoGridViewModel by lazy {
        ViewModelProvider(this).get(PhotoGridViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().title = "List"
        val binding = FragmentPhotoGridBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photosGrid.adapter = PhotoGridAdapter(PhotoGridAdapter.OnClickListener {
            viewModel.displayPropertyDetails(it)
        })

        viewModel.navigateToSelectedProperty.observe(this, Observer {
            if (null != it) {
                println(it)
                this.findNavController().navigate(PhotoGridFragmentDirections.actionShowDetail(it))
                viewModel.displayPropertyDetailsComplete()
            }
        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }
}