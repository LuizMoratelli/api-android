package br.com.luizmoratelli.api_android.helper;

import android.widget.EditText;

import br.com.luizmoratelli.api_android.FormActivity;
import br.com.luizmoratelli.api_android.R;
import br.com.luizmoratelli.api_android.model.Dados;

public class FormHelper {
    private EditText name;
    private EditText phone;
    private EditText address;
    private Dados dados;

    public FormHelper(FormActivity form) {
        name = form.findViewById(R.id.name);
        phone = form.findViewById(R.id.phone);
        address = form.findViewById(R.id.address);

        dados = new Dados();
    }

    public Dados getDadosFromForm() {
        dados.setName(name.getEditableText().toString());
        dados.setPhone(phone.getEditableText().toString());
        dados.setAddress(address.getEditableText().toString());

        return dados;
    }

    public void setDadosOnForm(Dados dados) {
        this.dados = dados;

        name.setText(dados.getName());
        phone.setText(dados.getPhone());
        address.setText(dados.getAddress());
    }
}
