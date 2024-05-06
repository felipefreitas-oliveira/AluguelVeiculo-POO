package br.com.cajazeiras.reservaveiculos.Model;

import br.com.cajazeiras.reservaveiculos.Enum.EnumIdVeiculo;

import java.util.Scanner;

abstract public class Veiculo {
    Scanner scanner = new Scanner(System.in);

    private int id;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private double valorDiaria;
    private boolean disponivel;
    private boolean reservado;
    private EnumIdVeiculo tipoVeiculo;

    public Veiculo(){}

    public Veiculo (int id, EnumIdVeiculo tipoVeiculo, String marca, String modelo, int anoFabricacao, double valorDiaria,boolean reservado, boolean disponivel){
        this.tipoVeiculo = tipoVeiculo;
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.valorDiaria = valorDiaria;
        this.reservado = reservado;
        this.disponivel = disponivel;
    }

    public static void listarFrota(Veiculo[] veiculos){
        for (int i = 0; i < veiculos.length; i++) {
            Veiculo veiculo = veiculos[i];
            if(veiculo.getDisponivel() && !veiculo.getReservado()){
                System.out.println("Veiculo " + veiculo.getId());
                System.out.println("Marca: " + veiculo.getMarca());
                System.out.println("Modelo: " + veiculo.getModelo());
                System.out.println("Ano: " + veiculo.getAnoFabricacao());
                System.out.printf("Valor Diária: %.2f\n", veiculo.getValorDiaria());
                if (veiculo.getId() == 1 && veiculo instanceof Carro){
                    Carro carro1 = (Carro) veiculo;
                    System.out.println("Capacidade de Pessoas: " + carro1.getCapacidadePessoas());
                    System.out.println("Categoria: " + carro1.getCategoria());
                }else{
                    Moto moto = (Moto) veiculo;
                    System.out.println("Cilindradas: " + moto.getCilindrada());
                }
            }
        }
    }


    public static void reserva(Veiculo[] veiculos){
        for (int i = 0; i < veiculos.length; i++) {
            Veiculo veiculo = veiculos[i];
            System.out.println("Veiculo " + veiculo.getId());
            System.out.println("Marca: " + veiculo.getMarca());
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println("Ano: " + veiculo.getAnoFabricacao());
            System.out.printf("Valor Diária: %.2f\n", veiculo.getValorDiaria());
            if (EnumIdVeiculo.CARRO == veiculo.getTipoVeiculo()){
                Carro carro1 = (Carro) veiculo;
                System.out.println("Capacidade de Pessoas: " + carro1.getCapacidadePessoas());
                System.out.println("Categoria: " + carro1.getCategoria());
            }else if (EnumIdVeiculo.MOTO == veiculo.getTipoVeiculo()){
                Moto moto = (Moto) veiculo;
                System.out.println("Cilindradas: " + moto.getCilindrada());
            }
            if (veiculo.getDisponivel()){
                System.out.println("Disponivel: SIM");
            }else{
                System.out.println("Disponivel: NÃO");
            }
            if (veiculo.getReservado()) {
                System.out.println("Reservado: SIM\n");
            } else {
                System.out.println("Reservado: NÃO\n");
            }
        }

        if(veiculos.length > 0){

            while (true) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("Gostaria de realizar uma reserva: [1] SIM [2] NÃO");
                int opc = scanner.nextInt();

                if(opc == 1) {
                    System.out.print("Escolha o id do Veiculo que gostaria de reservar: ");
                    int opcao = scanner.nextInt();

                    for (int i = 0; i < veiculos.length; i++) {
                        Veiculo veiculo = veiculos[i];
                        if (opcao == veiculo.getId()) {
                            if (!veiculo.getReservado() && veiculo.getDisponivel()) {
                                System.out.println("Veiculo reservado com Sucesso.\n");
                                veiculo.setReservado(true);
                            } else {
                                System.out.println("Veiculo ja está reservado ou alugado.\n");
                                break;
                            }
                        } else {
                            System.out.println("Veiculo não encontrado.\n");
                            break;
                        }
                    }
                }else if(opc == 2){
                    break;
                }else {
                    System.out.println("Opção invalida.");
                }
            }

        }else {
            System.out.println("Nenhum veiculo encontrado");
        }

    }

    public EnumIdVeiculo getTipoVeiculo() {return tipoVeiculo;}
    public int getId() {return id;}
    public String getMarca() {return marca;}
    public String getModelo() {return modelo;}
    public int getAnoFabricacao() {return anoFabricacao;}
    public double getValorDiaria() {return valorDiaria;}
    public boolean getDisponivel(){ return disponivel;}
    public boolean getReservado(){ return reservado;}

    public void setId (int id){this.id = id;}
    public void setMarca(String marca) {this.marca = marca;}
    public void setModelo(String modelo) {this.modelo = modelo;}
    public void setAnoFabricacao(int anoFabricacao) {this.anoFabricacao = anoFabricacao;}
    public void setValorDiaria(double valorDiaria) {this.valorDiaria = valorDiaria;}
    public void setDisponivel (boolean disponivel) {this.disponivel = disponivel;}
    public void setReservado (boolean reservado) {this.reservado = reservado;}
}