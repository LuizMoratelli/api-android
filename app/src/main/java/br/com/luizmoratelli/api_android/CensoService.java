package br.com.luizmoratelli.api_android;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.converter.gson.GsonConverterFactory;

public interface CensoService {
    @GET("/api/censo/{id}")
    Call<List<Coletor>> repoCenso(
            @Path("id") String repo
    );

    public static final Retrofit retrofit =
            new Retrofit.Builder()
            .baseUrl("https://whispering-headland-07022.herokuapp.com/api/censo")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
