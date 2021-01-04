package com.eden.machi.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView




class GridAdapter(context: Context, layoutId: Int,
                  imageList: List<Int>, members: List<String>) : BaseAdapter() {
    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
    }

    internal class ViewHolder {
        var imageView: ImageView? = null
        var textView: TextView? = null
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }

}