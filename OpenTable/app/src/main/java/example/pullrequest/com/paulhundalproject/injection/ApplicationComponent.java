package example.pullrequest.com.paulhundalproject.injection;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import example.pullrequest.com.paulhundalproject.ProjectApplication;
import example.pullrequest.com.services.retrofit.IRetrofitProvider;

/**
 * Created by phundal on 12/1/17.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface ApplicationComponent {
    void inject(ProjectApplication application);
    // Exported for child-components.
    Application application();
    IRetrofitProvider retrofitProvider();
}