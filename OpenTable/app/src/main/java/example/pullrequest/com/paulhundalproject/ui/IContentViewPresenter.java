package example.pullrequest.com.paulhundalproject.ui;

import example.pullrequest.com.paulhundalproject.framework.IPresenter;

/**
 * Created by phundal on 12/1/17.
 */

public interface IContentViewPresenter extends IPresenter<ContentView, Object> {
    void share(String emailBody);
}
