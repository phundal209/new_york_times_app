package example.pullrequest.com.paulhundalproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import javax.inject.Inject;

import example.pullrequest.com.paulhundalproject.injection.AppModule;
import example.pullrequest.com.paulhundalproject.injection.ApplicationComponent;
import example.pullrequest.com.paulhundalproject.injection.DaggerApplicationComponent;
import example.pullrequest.com.services.retrofit.IRetrofitProvider;

/**
 * Created by phundal on 12/1/17.
 */

public class ProjectApplication extends MultiDexApplication {

    private ApplicationComponent applicationComponent;

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    IRetrofitProvider retrofitProvider;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
