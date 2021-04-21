package in.welldoc.data.remote.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryService {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://gorest.co.in/public-api/";

    /**
     * Create an instance of Retrofit object
     * */
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
   /* private static final String URL = "https://gorest.co.in/public-api/";

    private CategoriesApi categoriesApi;

    private static CategoryService singleton;

    private CategoryService() {
        Retrofit mRetrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(URL).build();
        categoriesApi = mRetrofit.create(CategoriesApi.class);
    }

    public static CategoryService getInstance() {
        if (singleton == null) {
            singleton = new CategoryService();
        }
        return singleton;
    }

    public CategoriesApi getMovieApi() {
        return categoriesApi;
    }*/
}
