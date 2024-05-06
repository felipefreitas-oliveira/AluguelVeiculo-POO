package br.com.cajazeiras.reservaveiculos.Model;

public class Endereco {

    public String rua;
    public String numero;
    public String bairro;
    public String cidade;

    public Endereco(String rua, String numero, String bairro, String cidade){
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getRua() {return rua;}
    public String getCidade() {return cidade;}
    public String getBairro() {return bairro;}
    public String getNumero() {return numero;}

    public void setRua(String rua) {this.rua = rua;}
    public void setNumero(String numero) {this.numero = numero;}
    public void setBairro(String bairro) {this.bairro = bairro;}
    public void setCidade(String cidade) {this.cidade = cidade;}

    @Override
    public String toString() {
        return String.format("\nRua: %s, %s \nBairro: %s \nCidade: %s", rua,numero, bairro, cidade);
    }
}