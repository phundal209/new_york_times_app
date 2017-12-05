package example.pullrequest.com.paulhundalproject.ui.wrapper

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso
import example.pullrequest.com.opentable.R

/**
 * Created by phundal on 12/2/17.
 */
class MediaRenderer(context : Context) : IMediaRenderingWrapper {
    val context = context

    override fun displayMedia(url: String, imgView : ImageView) {
        Picasso.with(context).load(url).placeholder(R.mipmap.empty_photo).error(R.mipmap.empty_photo).into(imgView)
    }
}