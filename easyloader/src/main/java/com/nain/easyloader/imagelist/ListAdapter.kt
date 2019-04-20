package com.nain.easyloader.imagelist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.nain.easyloader.EasyLoader
import com.nain.easyloader.R
import android.app.Activity
import android.util.DisplayMetrics
import com.nain.easyloader.util.Utils.getDeviceMetrices


internal class ListAdapter(var list: List<String>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val displaymetrics = getDeviceMetrices(holder.imageView.context as Activity)

        val devicewidth = displaymetrics.widthPixels
        val deviceheight = displaymetrics.heightPixels / 4

        holder.imageView.getLayoutParams().width = devicewidth
        holder.imageView.getLayoutParams().height = deviceheight
        holder.imageView.scaleType = ImageView.ScaleType.FIT_XY


        val url: String = list[position]

        holder.imageView.invalidate()
        EasyLoader
            .imageBuilder()
            .src(url)
            .container(holder.imageView)
            .placeholder(R.drawable.placeholder)
            .build()
            .show()

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
        var imageView: ImageView

        init {
            imageView = itemView.findViewById(R.id.image_view)
        }

    }
}