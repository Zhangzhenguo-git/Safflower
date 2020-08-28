package com.pack.safflower.view.navigation.fragment.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.SizeUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.pack.safflower.R
import com.pack.safflower.databinding.HomeFragmentBinding

public class HomeViewModel : ViewModel() {

    public fun HomeViewModel() {

    }


    class ImageAdapter internal constructor(private val items: List<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.banner_item_image, parent, false)
            return ImageViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val imageViewHolder = holder as ImageViewHolder
            Glide.with(imageViewHolder.image)
                    .load(items[position])
                    .apply(RequestOptions()
                            .transform(RoundedCorners(SizeUtils.dp2px(10F))))
                    .into(imageViewHolder.image)
        }

        override fun getItemCount(): Int {
            return items.size
        }

    }

    internal class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView

        init {
            image = itemView.findViewById(R.id.img)
        }
    }

}