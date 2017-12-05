package example.pullrequest.com.paulhundalproject.injection;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import example.pullrequest.com.paulhundalproject.injection.annotation.PerActivity;
import example.pullrequest.com.services.retrofit.IRetrofitProvider;
import example.pullrequest.com.services.service.ApiService;
import example.pullrequest.com.services.service.IApiService;

/**
 * Created by phundal on 12/1/17.
 */

@Module
public class DataModule {
    private final Activity activity;

    public DataModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    IApiService providesApiService(IRetrofitProvider retrofitProvider) {
        return new ApiService(retrofitProvider);
    }
}
