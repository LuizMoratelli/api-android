package br.com.luizmoratelli.api_android.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Embedded implements Serializable {
    @SerializedName("censos")
    private final List<Censos> censos;

    public Embedded(List<Censos> censos) {
        this.censos = censos;
    }

    public List<Censos> getCensos() {
        return censos;
    }

}
