
package br.com.luizmoratelli.api_android.model;

public class Censo {
    private int coletor;
    private String dados;

    public int getColetor() {
        return coletor;
    }

    public void setColetor(int coletor) {
        this.coletor = coletor;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    @Override
    public String toString() {
        return "{\"coletor\":" + coletor + ", \"dados\": " + dados + "}";
    }
}