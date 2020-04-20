package br.com.luizmoratelli.api_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.com.luizmoratelli.api_android.adapter.CensoAdapter;
import br.com.luizmoratelli.api_android.model.Censos;
import br.com.luizmoratelli.api_android.model.CensosResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button button;
    ListView listView;

    @Override
    protected void onResume() {
        super.onResume();
        onListCensos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_censo:
                Intent intent = new Intent(
                        MainActivity.this,
                        FormActivity.class
                );
                startActivity(intent);
                break;
            default:
                Toast.makeText(
                        MainActivity.this,
                        "NOT IMPLEMENTED YET",
                        Toast.LENGTH_LONG
                ).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onListCensos();
            }
        });
    }

    private void onListCensos() {
        CensoService censoService =
                CensoService.retrofit.create(CensoService.class);

        final Call<CensosResponse> call =
                censoService.repoColetor(1006852);

        call.enqueue(new Callback<CensosResponse>() {
            @Override
            public void onResponse(Call<CensosResponse> call,
                                   Response<CensosResponse> response) {
                final List<Censos> censos = response.body().getEmbedded().getCensos();

                CensoAdapter adapter = new CensoAdapter(MainActivity.this, (ArrayList<Censos>) censos);
                listView.setAdapter(adapter);
                if (censos.size() == 0) {
                    Toast.makeText(
                            MainActivity.this,
                            "Nenhum censo encontrado!",
                            Toast.LENGTH_LONG
                    ).show();
                }
            }

            @Override
            public void onFailure(Call<CensosResponse> call,
                                  Throwable t) {
                Toast.makeText(
                        MainActivity.this,
                        "Erro: " + t.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}
