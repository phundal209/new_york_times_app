package example.pullrequest.com.paulhundalproject.framework;

/**
 * Created by phundal on 12/1/17.
 */

public interface IPresenter<V extends ViewScreen, TModel> {
    /**
     * Make sure that either the constructor does butterknife view injection
     * or you explicitly call getView().withRootView() before calling this method
     */
    void bindControls();

    V getView();

    IPresenter<V, TModel> withModel(TModel model);

    TModel getModel();

    void hide();

    void show();

    void toggleVisibiility();
}
