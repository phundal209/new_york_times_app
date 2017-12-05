package example.pullrequest.com.services.rest;


import example.pullrequest.com.api.MediaResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by phundal on 12/1/17.
 */

public interface IRestClient {
    @GET("svc/movies/v2/reviews/dvd-picks.json?order=by-date&api-key=b75da00e12d54774a2d362adddcc9bef")
    Observable<MediaResponse> getMedia();
}
