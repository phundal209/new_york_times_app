package example.pullrequest.com.paulhundalproject.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import example.pullrequest.com.api.MediaResponse;
import example.pullrequest.com.opentable.R;
import example.pullrequest.com.paulhundalproject.framework.Presenter;
import example.pullrequest.com.paulhundalproject.ui.adapter.ContentViewRecyclerAdapter;
import example.pullrequest.com.paulhundalproject.ui.wrapper.IMediaRenderingWrapper;
import example.pullrequest.com.paulhundalproject.ui.wrapper.IShareServiceWrapper;
import example.pullrequest.com.paulhundalproject.ui.wrapper.ITextParser;
import example.pullrequest.com.services.service.IApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by phundal on 12/1/17.
 */

public class ContentViewPresenter extends Presenter<ContentView, Object> implements IContentViewPresenter {

    private IApiService apiService;
    private IMediaRenderingWrapper mediaRenderingWrapper;
    private ITextParser textParser;
    private ContentViewRecyclerAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private IShareServiceWrapper shareServiceWrapper;

    private ProgressDialog progressDialog;

    public ContentViewPresenter(Context context, ContentView view, IApiService apiService, IMediaRenderingWrapper mediaRenderingWrapper,
                                ITextParser textParser, IShareServiceWrapper shareServiceWrapper) {
        super(context, view, false);
        this.apiService = apiService;
        this.mediaRenderingWrapper = mediaRenderingWrapper;
        this.textParser = textParser;
        this.shareServiceWrapper = shareServiceWrapper;
    }

    @Override
    public void bindControls() {
        view.get_movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
                if(adapter != null) {
                    adapter.clear();
                }
                makeApiCall();
            }
        });
    }

    private void makeApiCall() {
        apiService.getMedia().observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).
                onErrorReturn(new Function<Throwable, MediaResponse>() {
                    @Override
                    public MediaResponse apply(Throwable throwable) throws Exception {
                        return new MediaResponse();
                    }
                }).
                subscribe(new Consumer<MediaResponse>() {
            @Override
            public void accept(MediaResponse mediaResponse) throws Exception {
                adapter = new ContentViewRecyclerAdapter(mediaResponse.getResults(), context, textParser, mediaRenderingWrapper, ContentViewPresenter.this);
                linearLayoutManager = new LinearLayoutManager(context);
                view.recycler.setLayoutManager(linearLayoutManager);
                view.recycler.setAdapter(adapter);
                hide();
            }
        });
    }

    @Override
    public void hide() {
        if(progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void show() {
        if(progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage(context.getString(R.string.waiting_message));
            progressDialog.show();
        }
    }

    @Override
    public void share(String emailBody) {
        shareServiceWrapper.shareWithEmail(emailBody);
    }
}
