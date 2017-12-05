package example.pullrequest.com.services.service;

import example.pullrequest.com.api.MediaResponse;
import example.pullrequest.com.services.rest.IRestClient;
import example.pullrequest.com.services.retrofit.IRetrofitProvider;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by phundal on 12/1/17.
 */

public class ApiService implements IApiService{
    private IRestClient restClient;

    public ApiService(IRetrofitProvider retrofitProvider) {
        this.restClient = retrofitProvider.getRetrofit().create(IRestClient.class);
    }

    @Override
    public Observable<MediaResponse> getMedia() {
        return restClient.getMedia().map(new Function<MediaResponse, MediaResponse>() {
            @Override
            public MediaResponse apply(MediaResponse mediaResponse) throws Exception {
                if(mediaResponse != null) {
                    return mediaResponse;
                }
                return new MediaResponse();
            }
        });
    }
}
