package br.com.cajazeiras.reservaveiculos.Model;

abstract public class Pessoa {
    private int id = 0;
    public String nome;
    public String telefone;
    public Endereco endereco;

    public Pessoa(){}

    public Pessoa(int id, String nome, String telefone, Endereco endereco){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public int getId() {return id;}
    public String getNome() {return nome;}
    public Endereco getEndereco() {return endereco;}
    public String getTelefone() {return telefone;}

    public void setId (int id){this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public void setEndereco(Endereco endereco) {this.endereco = endereco;}
}
