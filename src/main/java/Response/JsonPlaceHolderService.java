package Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class JsonPlaceHolderService {
    private static JsonPlaceHolderService instance;
    private static JsonPlaceholderApi api;
    private static final String BASE_URL = "https://api.weatherapi.com";

    private static JsonPlaceholderApi init(){
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();

        JsonPlaceholderApi api = retrofit.create(JsonPlaceholderApi.class);
        return api;
    }

    public static JsonPlaceholderApi instance() {
        if (api == null) {
            api = init();
        }
        return api;
    }
}
