package br.com.cajazeiras.reservaveiculos.Model;

import br.com.cajazeiras.reservaveiculos.Enum.EnumIdVeiculo;

public class Moto extends Veiculo{

    public int cilindrada;

    public Moto(){}

    public Moto(int id, EnumIdVeiculo tipoVeiculo, String marca, String modelo, int anoFabricacao, double valorDiaria, int cilindrada, boolean reservado, boolean disponivel){
        super(id,tipoVeiculo, marca, modelo, anoFabricacao, valorDiaria, reservado, disponivel);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {return cilindrada;}

    public void setCilindrada(int cilindrada) {this.cilindrada = cilindrada;}
}
