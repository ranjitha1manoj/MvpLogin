package in.welldoc.data.remote.services;
import in.welldoc.data.remote.model.NoticeList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriesApi {
    @GET("categories/")
    Call<NoticeList> getCategory();
}
