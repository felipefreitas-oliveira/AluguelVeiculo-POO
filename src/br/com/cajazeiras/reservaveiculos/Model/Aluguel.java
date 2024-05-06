package br.com.cajazeiras.reservaveiculos.Model;

import br.com.cajazeiras.reservaveiculos.Interface.IAluguel;

import java.util.Scanner;

public class Aluguel extends Contrato implements IAluguel {

    public Aluguel(Cliente cliente, Veiculo veiculo){

        super(cliente, veiculo);
    }


    @Override
    public double calcularValorAluguel(int dias, int formaPagamento) {
        Scanner scanner = new Scanner(System.in);

        if(formaPagamento == 1){
            double percent = (this.veiculo.getValorDiaria() * dias) * 0.05;
            return (this.veiculo.getValorDiaria() * dias) - percent;
        }else if(formaPagamento == 2){
            System.out.println("Em quantas parcelas: ");
            int parcela = scanner.nextInt();
            return (this.veiculo.getValorDiaria() * dias) * parcela;
        }else {
            double percent = (this.veiculo.getValorDiaria() * dias) * 0.10;
            return this.veiculo.getValorDiaria() * dias - percent;
        }
    }

    @Override
    public void realizaAluguel() {
        this.veiculo.setDisponivel(false);
        System.out.printf("%s %s alugado com sucesso para o cliente %s.\n",this.veiculo.getMarca(), this.veiculo.getModelo(), this.cliente.getNome());
    }
}
