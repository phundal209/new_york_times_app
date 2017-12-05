package example.pullrequest.com.paulhundalproject.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import example.pullrequest.com.paulhundalproject.ProjectApplication;
import example.pullrequest.com.opentable.R;
import example.pullrequest.com.paulhundalproject.injection.ActivityModule;
import example.pullrequest.com.paulhundalproject.injection.DaggerMainActivityComponent;
import example.pullrequest.com.paulhundalproject.injection.DataModule;
import example.pullrequest.com.paulhundalproject.injection.MainActivityComponent;

public class MainActivity extends AppCompatActivity {

    private MainActivityComponent component;
    @Inject
    IContentViewPresenter contentViewPresenter;

    MainActivityComponent component() {
        if (component == null) {
            component = DaggerMainActivityComponent.builder()
                    .applicationComponent((getOpenTableApplication()).getComponent())
                    .activityModule(new ActivityModule(this))
                    .dataModule(new DataModule(this))
                    .build();
        }
        return component;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        component().inject(this);

        contentViewPresenter
                .getView()
                .withRootView(this.findViewById(android.R.id.content).getRootView());
        contentViewPresenter.bindControls();
    }

    private ProjectApplication getOpenTableApplication() {
        return (ProjectApplication) getApplication();
    }
}
