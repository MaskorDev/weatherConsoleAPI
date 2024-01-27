package Response;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class JsonPlaceHolderService {
    private Retrofit retrofit;
    private static JsonPlaceHolderService instance;

    private static final String BASE_URL = "https://api.weatherapi.com/v1/";

    private JsonPlaceHolderService(){
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();


        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();
    }

    public static JsonPlaceHolderService getInstance() {
        if(instance == null) {
            instance = new JsonPlaceHolderService();
        }
        return instance;
    }

    public JsonPlaceholderApi api() {
        return retrofit.create(JsonPlaceholderApi.class);
    }

}
