package in.welldoc.data.remote.services;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
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
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .build();
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
