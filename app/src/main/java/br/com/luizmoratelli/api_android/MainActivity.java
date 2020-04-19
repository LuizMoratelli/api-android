package br.com.luizmoratelli.api_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                CensoService censoService = CensoService.retrofit.create(CensoService.class);

                final Call<List<Coletor>> call = censoService.repoCenso("1006852");

                call.enqueue(new Callback<List<Coletor>>() {
                    @Override
                    public void onResponse(Call<List<Coletor>> call, Response<List<Coletor>> response) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<List<Coletor>> call, Throwable t) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Erro:" + t.getMessage());
                    }
                });
            }
        });
    }
}
