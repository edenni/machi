package com.eden.machi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eden.machi.databinding.GridViewItemBinding
import com.eden.machi.network.StreetImageProperty


class PhotoGridAdapter( private val onClickListener: OnClickListener) :
        ListAdapter<StreetImageProperty,
        PhotoGridAdapter.StreetImagePropertyViewHolder>(DiffCallback) {

    class StreetImagePropertyViewHolder(private var binding: GridViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(streetImageProperty: StreetImageProperty) {
            binding.property = streetImageProperty
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<StreetImageProperty>() {
        override fun areItemsTheSame(oldItem: StreetImageProperty, newItem: StreetImageProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: StreetImageProperty, newItem: StreetImageProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): StreetImagePropertyViewHolder {
        return StreetImagePropertyViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: StreetImagePropertyViewHolder, position: Int) {
        val streetImageProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(streetImageProperty)
        }
        holder.bind(streetImageProperty)
    }

    class OnClickListener(val clickListener: (streetImageProperty : StreetImageProperty) -> Unit) {
        fun onClick(streetImageProperty : StreetImageProperty) = clickListener(streetImageProperty)
    }
}