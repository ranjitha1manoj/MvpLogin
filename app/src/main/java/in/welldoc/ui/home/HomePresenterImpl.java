package in.welldoc.ui.home;

import java.util.ArrayList;

import in.welldoc.data.remote.model.Datum;

public class HomePresenterImpl implements HomeContract.presenter, HomeContract.GetNoticeIntractor.OnFinishedListener {

    private HomeContract.MainView mainView;
    private HomeContract.GetNoticeIntractor getNoticeIntractor;

    public HomePresenterImpl(HomeContract.MainView mainView,HomeContract.GetNoticeIntractor getNoticeIntractor) {
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
        getNoticeIntractor.getNoticeArrayList(this);

    }

    @Override
    public void requestDataFromServer() {
        getNoticeIntractor.getNoticeArrayList(this);
    }


    @Override
    public void onFinished(ArrayList<Datum> noticeArrayList) {
        if (mainView != null) {
            mainView.setDataToRecyclerView(noticeArrayList);
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