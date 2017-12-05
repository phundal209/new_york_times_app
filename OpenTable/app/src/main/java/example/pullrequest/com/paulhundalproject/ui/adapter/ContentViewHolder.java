package example.pullrequest.com.paulhundalproject.ui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.Bind;
import example.pullrequest.com.opentable.R;

/**
 * Created by phundal on 12/3/17.
 */

public class ContentViewHolder extends RecyclerView.ViewHolder {
    CardView card_view;
    TextView headline;
    TextView displayTitle;
    TextView displayRating;
    TextView movieByline;
    TextView publicationDate;
    TextView summaryShort;
    TextView link;
    ImageView mediaImage;
    TextView shareText;

    public ContentViewHolder(View itemView) {
        super(itemView);

        card_view = (CardView) itemView.findViewById(R.id.card_view);
        headline = (TextView) itemView.findViewById(R.id.headline);
        displayTitle = (TextView) itemView.findViewById(R.id.displayTitle);
        displayRating = (TextView) itemView.findViewById(R.id.displayRating);
        movieByline = (TextView) itemView.findViewById(R.id.movieByline);
        publicationDate = (TextView) itemView.findViewById(R.id.publicationDate);
        summaryShort = (TextView) itemView.findViewById(R.id.summaryShort);
        link = (TextView) itemView.findViewById(R.id.link);
        mediaImage = (ImageView) itemView.findViewById(R.id.mediaImage);
        shareText = (TextView) itemView.findViewById(R.id.shareText);
    }
}
