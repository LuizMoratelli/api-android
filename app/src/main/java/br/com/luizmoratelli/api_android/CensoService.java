package br.com.luizmoratelli.api_android;

import br.com.luizmoratelli.api_android.model.Censo;
import br.com.luizmoratelli.api_android.model.CensosResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CensoService {
    @GET("censo/search/findByColetor")
    Call<CensosResponse> repoColetor(
            @Query("coletor") int coletor
    );

    @POST("api/censo")
    Call<CensosResponse> repoPost(
            @Body Censo censo
    );

    @PATCH("censo/{id}")
    Call<CensosResponse> repoPatch(
            @Body Censo censo,
            @Path("id") Integer id
    );

    Retrofit retrofit =
            new Retrofit.Builder()
            .baseUrl("https://whispering-headland-07022.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
