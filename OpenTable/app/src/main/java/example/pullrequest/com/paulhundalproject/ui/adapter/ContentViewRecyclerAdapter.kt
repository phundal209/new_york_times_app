package example.pullrequest.com.paulhundalproject.ui.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import example.pullrequest.com.api.MediaResponse
import example.pullrequest.com.opentable.R
import example.pullrequest.com.paulhundalproject.ui.IContentViewPresenter
import example.pullrequest.com.paulhundalproject.ui.wrapper.ITextParser
import example.pullrequest.com.paulhundalproject.ui.wrapper.IMediaRenderingWrapper

/**
 * Created by phundal on 12/1/17.
 */
open class ContentViewRecyclerAdapter(listOfMedia : MutableList<MediaResponse.Results>, context : Context,
                                      textWrapper : ITextParser, mediaWrapper : IMediaRenderingWrapper,
                                      presenter : IContentViewPresenter) : RecyclerView.Adapter<ContentViewHolder>() {

    var listOfMedia = listOfMedia
    var context = context
    var textWrapper = textWrapper
    var mediaWrapper = mediaWrapper
    var presenter = presenter

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ContentViewHolder?, position: Int) {
        val mediaItem = listOfMedia[position]
        var movieRating = textWrapper.getParsedString(mediaItem.mpaa_rating)
        if(!movieRating.isEmpty()) {
            holder?.displayRating?.text = context.getString(R.string.rated) + " " + movieRating
        } else {
            holder?.displayRating?.text = context.getString(R.string.not_rated)
        }
        holder?.displayTitle?.text = context.getString(R.string.movie_title) + " " +textWrapper.getParsedString(mediaItem.display_title)
        holder?.headline?.text = textWrapper.getParsedString(mediaItem.headline)
        holder?.movieByline?.text = context.getString(R.string.by_line) + " " +textWrapper.getParsedString(mediaItem.byline)
        holder?.publicationDate?.text = context.getString(R.string.publication_date) + " " + mediaItem.publication_date
        holder?.summaryShort?.text = context.getString(R.string.summary) + " " + textWrapper.getParsedString(mediaItem.summary_short)

        holder?.link.apply {
            try {
                holder?.link?.text = textWrapper.getParsedString(mediaItem.link.suggested_link_text)
                holder?.link?.setOnClickListener(View.OnClickListener {
                    var intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(mediaItem.link.url))
                    var activity: Activity = context as Activity
                    if (intent.resolveActivity(activity.packageManager) != null) {
                        activity.startActivity(intent)
                    }
                })
            } catch (ex : Exception) {
                Log.e(ContentViewRecyclerAdapter::class.java.simpleName, "unable to parse uri", ex)
            }
        }
        if(holder?.mediaImage != null) {
            mediaWrapper.displayMedia(mediaItem.multimedia.src, holder.mediaImage)
        }

        val emailBody = mediaItem.display_title + "\n" + mediaItem.mpaa_rating + "\n" + mediaItem.summary_short + "\n" + Uri.parse(mediaItem.link.url)
        holder?.shareText?.setOnClickListener {
            presenter.share(emailBody)
        }
    }

    fun clear() {
        if(listOfMedia.isNotEmpty()) {
            listOfMedia.clear()
            notifyDataSetChanged()
        }
    }
    override fun getItemCount(): Int = listOfMedia.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ContentViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.media_summary_item, parent, false)
        val vh = ContentViewHolder(v)
        return vh
    }
}