package in.welldoc.ui.home;

import java.util.ArrayList;

import in.welldoc.data.remote.model.Datum;

public interface HomeContract {
    interface presenter{

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();

    }


    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<Datum> noticeArrayList);

        void onResponseFailure(Throwable throwable);

    }


    interface GetNoticeIntractor {

        interface OnFinishedListener {
            void onFinished(ArrayList<Datum> noticeArrayList);
            void onFailure(Throwable t);
        }

        void getNoticeArrayList(OnFinishedListener onFinishedListener);
    }
}

