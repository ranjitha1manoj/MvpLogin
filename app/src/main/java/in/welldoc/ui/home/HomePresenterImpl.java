package in.welldoc.ui.home;

import java.util.ArrayList;

import in.welldoc.data.remote.model.Datum;

public class HomePresenterImpl implements HomeContract.presenter, HomeContract.GetCategoryIntractor.OnFinishedListener {

    private HomeContract.MainView mainView;
    private HomeContract.GetCategoryIntractor getNoticeIntractor;

    public HomePresenterImpl(HomeContract.MainView mainView,HomeContract.GetCategoryIntractor getNoticeIntractor) {
        this.mainView = mainView;
        this.getNoticeIntractor = getNoticeIntractor;
    }

    @Override
    public void onDestroy() {

        mainView = null;

    }

    @Override
    public void onRefreshButtonClick() {

        if (mainView != null) {
            mainView.showProgress();
        }
        getNoticeIntractor.getCategoryArrayList(this);

    }

    @Override
    public void requestDataFromServer() {
        getNoticeIntractor.getCategoryArrayList(this);
    }


    @Override
    public void onFinished(ArrayList<Datum> categoryArrayList) {
        if (mainView != null) {
            mainView.setDataToRecyclerView(categoryArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if (mainView != null) {
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}