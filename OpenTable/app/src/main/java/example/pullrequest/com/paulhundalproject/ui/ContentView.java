package example.pullrequest.com.paulhundalproject.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import example.pullrequest.com.opentable.R;
import example.pullrequest.com.paulhundalproject.framework.ViewScreen;

/**
 * Created by phundal on 12/1/17.
 */

public class ContentView extends ViewScreen {
    @Bind(R.id.recycler)
    public RecyclerView recycler;

    @Bind(R.id.get_movies)
    public Button get_movies;

    public ContentView(View rootView) {
        super(rootView);
    }
}
