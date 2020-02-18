package com.amier.kotlinmvvmgithubapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator


val picasso: Picasso
    get() = Picasso.get()

fun ImageView.load(path:String,request:(RequestCreator) ->RequestCreator){
    request(picasso.load(path)).into(this)
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView,url:String?){
    if (url!=null){
        view.load(url){requestCreator ->
            requestCreator.fit().centerCrop()
        }
    }
}
