package example.pullrequest.com.services.service;


import example.pullrequest.com.api.MediaResponse;
import io.reactivex.Observable;

/**
 * Created by phundal on 12/1/17.
 */

public interface IApiService {
    Observable<MediaResponse> getMedia();
}
