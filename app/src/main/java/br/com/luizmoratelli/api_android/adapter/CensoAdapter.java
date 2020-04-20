package br.com.luizmoratelli.api_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.util.ArrayList;

import br.com.luizmoratelli.api_android.R;
import br.com.luizmoratelli.api_android.model.Censos;
import br.com.luizmoratelli.api_android.model.Dados;

public class CensoAdapter extends ArrayAdapter<Censos> {
    public CensoAdapter(Context context, ArrayList<Censos> censos) {
        super(context, 0, censos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Censos censos = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView link = (TextView) convertView.findViewById(R.id.link);

        Dados dados = (new Gson()).fromJson(censos.getDados(), Dados.class);

        name.setText(dados.getName());
        link.setText(censos.getLinks().getSelf().getHref());

        return convertView;
    }
}
