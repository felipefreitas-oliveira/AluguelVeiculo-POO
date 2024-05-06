package br.com.cajazeiras.reservaveiculos.Model;

import br.com.cajazeiras.reservaveiculos.Enum.EnumCategoria;
import br.com.cajazeiras.reservaveiculos.Enum.EnumIdVeiculo;

public class Carro extends Veiculo {

    public int capacidadePessoas;
    public EnumCategoria categoria;
    public EnumIdVeiculo idVeiculo;

    public Carro(){}

    public Carro(int id, EnumIdVeiculo tipoVeiculo, String marca, String modelo, int anoFabricacao, double valorDiaria, EnumCategoria categoria, int capacidadePessoas,boolean reservado, boolean disponivel) {
        super(id, tipoVeiculo, marca, modelo, anoFabricacao, valorDiaria,reservado, disponivel);
        this.categoria = categoria;
        this.capacidadePessoas = capacidadePessoas;

    }

    public int getCapacidadePessoas() {return capacidadePessoas;}
    public EnumCategoria getCategoria(){return categoria;}

    public void setCapacidadePessoas(int capacidadePessoas){this.capacidadePessoas = capacidadePessoas;}
    public void setCategoria(EnumCategoria categoria) {this.categoria = categoria;}
}