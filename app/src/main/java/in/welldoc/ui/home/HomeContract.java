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

        void setDataToRecyclerView(ArrayList<Datum> categoryArrayList);

        void onResponseFailure(Throwable throwable);

    }


    interface GetCategoryIntractor {

        interface OnFinishedListener {
            void onFinished(ArrayList<Datum> categoryArrayList);
            void onFailure(Throwable t);
        }

        void getCategoryArrayList(OnFinishedListener onFinishedListener);
    }
}

