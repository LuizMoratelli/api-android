package br.com.luizmoratelli.api_android;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.luizmoratelli.api_android.model.Censos;
import br.com.luizmoratelli.api_android.model.CensosResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button button;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CensoService censoService =
                        CensoService.retrofit.create(CensoService.class);

                final Call<CensosResponse> call =
                        censoService.repoColetor(1001);

                call.enqueue(new Callback<CensosResponse>() {
                    @Override
                    public void onResponse(Call<CensosResponse> call,
                                           Response<CensosResponse> response) {
                        final List<Censos> censos = response.body().getEmbedded().getCensos();

                        System.out.println(censos.size());
                        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, censos);
                        listView.setAdapter(adapter);
                        //final TextView textView =
                          //      (TextView) findViewById(R.id.textView);
                        //textView.setText(response.body().getEmbedded().getCensos().get(0).getLinks().getSelf().getHref());
                    }

                    @Override
                    public void onFailure(Call<CensosResponse> call,
                                          Throwable t) {
                        //final TextView textView =
                        //        (TextView) findViewById(R.id.textView);
                        //textView.setText("Erro: " + t.getMessage());
                    }
                });
            }
        });
    }
}
