package example.pullrequest.com.paulhundalproject.injection;

import dagger.Component;
import example.pullrequest.com.paulhundalproject.ui.MainActivity;
import example.pullrequest.com.paulhundalproject.injection.annotation.PerActivity;

/**
 * Created by phundal on 12/1/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, DataModule.class})
public interface MainActivityComponent extends AbstractActivityComponent {
    void inject(MainActivity mainActivity);
}