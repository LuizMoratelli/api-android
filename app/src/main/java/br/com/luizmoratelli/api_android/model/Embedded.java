package br.com.luizmoratelli.api_android.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Embedded {
    @SerializedName("censos")
    private final List<Censos> censos;

    public Embedded(List<Censos> censos) {
        this.censos = censos;
    }

    public List<Censos> getCensos() {
        return censos;
    }

}
