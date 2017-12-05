package example.pullrequest.com.paulhundalproject.injection;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import example.pullrequest.com.paulhundalproject.injection.annotation.PerActivity;
import example.pullrequest.com.paulhundalproject.ui.ContentView;
import example.pullrequest.com.paulhundalproject.ui.ContentViewPresenter;
import example.pullrequest.com.paulhundalproject.ui.IContentViewPresenter;
import example.pullrequest.com.paulhundalproject.ui.wrapper.IMediaRenderingWrapper;
import example.pullrequest.com.paulhundalproject.ui.wrapper.IShareServiceWrapper;
import example.pullrequest.com.paulhundalproject.ui.wrapper.ITextParser;
import example.pullrequest.com.paulhundalproject.ui.wrapper.MediaRenderer;
import example.pullrequest.com.paulhundalproject.ui.wrapper.ShareService;
import example.pullrequest.com.paulhundalproject.ui.wrapper.TextParser;
import example.pullrequest.com.services.service.IApiService;

/**
 * Created by phundal on 12/1/17.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity activity() {
        return activity;
    }

    @Provides
    @PerActivity
    IMediaRenderingWrapper providesMediaRenderingWrapper() {
        return new MediaRenderer(activity);
    }

    @Provides
    @PerActivity
    ITextParser providesTextParser() {
        return new TextParser();
    }

    @Provides
    @PerActivity
    IShareServiceWrapper providesShareServiceWrapper() {
        return new ShareService(activity);
    }

    @Provides
    @PerActivity
    IContentViewPresenter loginPresenter(IApiService apiService, IMediaRenderingWrapper mediaRenderingWrapper, ITextParser textParser, IShareServiceWrapper shareServiceWrapper) {
        return new ContentViewPresenter(activity, new ContentView(activity
                .findViewById(android.R.id.content)), apiService, mediaRenderingWrapper, textParser, shareServiceWrapper);
    }
}
