package in.welldoc.ui.home;

import android.util.Log;

import in.welldoc.data.remote.model.NoticeList;
import in.welldoc.data.remote.services.CategoriesApi;
import in.welldoc.data.remote.services.CategoryService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class GetNoticeIntractorImpl implements HomeContract.GetNoticeIntractor {

    @Override
    public void getNoticeArrayList(final HomeContract.GetNoticeIntractor.OnFinishedListener onFinishedListener) {


        /** Create handle for the RetrofitInstance interface*/
        CategoriesApi service = CategoryService.getRetrofitInstance().create(CategoriesApi.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<NoticeList> call = service.getCategory();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {
                onFinishedListener.onFinished(response.body().getNoticeArrayList());

            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}
