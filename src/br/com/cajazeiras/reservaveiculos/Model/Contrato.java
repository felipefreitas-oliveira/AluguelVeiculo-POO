package br.com.cajazeiras.reservaveiculos.Model;

abstract public class Contrato {
    Cliente cliente;
    Veiculo veiculo;

    public Contrato(Cliente cliente, Veiculo veiculo){
        this.cliente = cliente;
        this.veiculo = veiculo;
    }
}
