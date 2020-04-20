package br.com.luizmoratelli.api_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import br.com.luizmoratelli.api_android.helper.FormHelper;
import br.com.luizmoratelli.api_android.model.Censo;
import br.com.luizmoratelli.api_android.model.Censos;
import br.com.luizmoratelli.api_android.model.CensosResponse;
import br.com.luizmoratelli.api_android.model.Dados;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormActivity extends AppCompatActivity {
    private Button button;
    private Censos censosToUpdate;

    private void sendPost(Censo censo) {
        CensoService service = CensoService.retrofit.create(CensoService.class);
        final Call<CensosResponse> call = service.repoPost(censo);

        call.enqueue(new Callback<CensosResponse>() {
            @Override
            public void onResponse(Call<CensosResponse> call, Response<CensosResponse> response) {
                    Toast.makeText(
                            FormActivity.this,
                            "Inserido com sucesso!",
                            Toast.LENGTH_LONG
                    ).show();
            }

            @Override
            public void onFailure(Call<CensosResponse> call, Throwable throwable) {
                Toast.makeText(
                        FormActivity.this,
                        "Falha ao inserir!",
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Censos censos = (Censos) getIntent().getSerializableExtra("selected_censo");
            if (censos != null) {
                this.censosToUpdate = censos;
                Dados dados = (new Gson()).fromJson(censos.getDados(), Dados.class);
                (new FormHelper(FormActivity.this)).setDadosOnForm(dados);
            }
        }

        button = findViewById(R.id.button);

        addListeners();
    }

    private void addListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (censosToUpdate == null) {
                    saveCensos();
                } else {
                   updateCensos();
                }
                finish();
            }
        });
    }
    private void saveCensos() {
        Dados dadosForm = (new FormHelper(FormActivity.this)).getDadosFromForm();

        Censo censo = new Censo();
        censo.setColetor(1006852);
        censo.setDados(dadosForm.toString());

        sendPost(censo);
    }

    private void updateCensos() {
    }
}
