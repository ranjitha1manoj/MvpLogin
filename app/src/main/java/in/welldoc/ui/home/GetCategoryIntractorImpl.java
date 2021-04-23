package in.welldoc.ui.home;

import android.util.Log;

import in.welldoc.data.remote.model.CategoryList;
import in.welldoc.data.remote.services.CategoriesApi;
import in.welldoc.data.remote.services.CategoryService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class GetCategoryIntractorImpl implements HomeContract.GetCategoryIntractor {

    @Override
    public void getCategoryArrayList(final HomeContract.GetCategoryIntractor.OnFinishedListener onFinishedListener) {


        /** Create handle for the RetrofitInstance interface*/
        CategoriesApi service = CategoryService.getRetrofitInstance().create(CategoriesApi.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<CategoryList> call = service.getCategory();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<CategoryList>() {
            @Override
            public void onResponse(Call<CategoryList> call, Response<CategoryList> response) {
                onFinishedListener.onFinished(response.body().getNoticeArrayList());
            }

            @Override
            public void onFailure(Call<CategoryList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}
