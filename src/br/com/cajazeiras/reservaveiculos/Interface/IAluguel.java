package br.com.cajazeiras.reservaveiculos.Interface;

public interface IAluguel {

    double calcularValorAluguel(int dias, int formaPagamento);

    void realizaAluguel();
}
