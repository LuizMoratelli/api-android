package br.com.luizmoratelli.api_android;

public class Coletor {
    String coletor;
    ColetorDados dados;

    @Override
    public String toString() { return coletor + "(" + dados.toString() + ")";}
}
