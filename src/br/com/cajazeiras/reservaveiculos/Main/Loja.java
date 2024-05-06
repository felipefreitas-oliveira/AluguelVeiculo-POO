package br.com.cajazeiras.reservaveiculos.Main;

import br.com.cajazeiras.reservaveiculos.Enum.EnumAcesso;
import br.com.cajazeiras.reservaveiculos.Enum.EnumCategoria;
import br.com.cajazeiras.reservaveiculos.Enum.EnumIdVeiculo;
import br.com.cajazeiras.reservaveiculos.Enum.EnumMenuLogin;
import br.com.cajazeiras.reservaveiculos.Model.*;

import java.util.Scanner;

public class Loja{
    public static void main(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);
            Veiculo[] veiculos = new Veiculo[0];
            Cliente[] clientes = new Cliente[0];
            Funcionario funcionario = new Funcionario("felipe", "123");
            Carro carro = new Carro();
            Cliente cliente = new Cliente();
            Moto moto = new Moto();

            System.out.println("MENU");

            for (int i = 0; i < EnumAcesso.values().length; i++) {
                int op = EnumAcesso.values()[i].value;
                String nome = EnumAcesso.values()[i].toString();

                System.out.printf("[%d] %s\n", op, nome);
            }

            System.out.print("Digite a opção: ");
            int op = scanner.nextInt();

            if(op == 1){

                funcionario.cadastrarLogin();

            }else if(op == 2){

                if (funcionario.autenticacao()) {

                    while (true) {
                        for (int i = 0; i < EnumMenuLogin.values().length; i++) {
                            op = EnumMenuLogin.values()[i].value;
                            String nome = EnumMenuLogin.values()[i].toString();

                            System.out.printf("[%d] %s\n", op, nome);
                        }

                        System.out.print("Digite a opção: ");
                        op = scanner.nextInt();

                        if (op == 1) {

                            clientes = cliente.cadastrar(clientes, cliente);

                        } else if (op == 2) {

                            cliente.atualizarCadastro(clientes, cliente);

                        } else if (op == 3) {

                            cliente.listarClientes(clientes);

                        } else if (op == 4) {

                            scanner = new Scanner(System.in);

                            System.out.println("[1]Carro [2]Moto");
                            int opc = scanner.nextInt();

                            Veiculo[] vetorAux = new Veiculo[veiculos.length + 1];

                            for (int i = 0; i < veiculos.length; i++){
                                vetorAux[i] = veiculos[i];
                            }

                            System.out.println("Veiculo " + (vetorAux.length) + ":");
                            int id = vetorAux.length;

                            scanner = new Scanner(System.in);

                            System.out.print("Marca: ");
                            String marca = scanner.nextLine();

                            System.out.print("Modelo: ");
                            String modelo = scanner.nextLine();

                            System.out.print("Ano Fabricação: ");
                            int anoFabricacao = scanner.nextInt();

                            System.out.print("Valor da Diaria: ");
                            double valorDiaria = scanner.nextDouble();

                            boolean disponivel = true;
                            boolean reservado = false;

                            if(opc == 1){

                                EnumIdVeiculo tipoVeiculo = EnumIdVeiculo.CARRO;

                                System.out.println("Categoria: [1]ECONOMICO [2]SEDAN [3]SUV [4]EXECUTIVO");
                                int categoria = scanner.nextInt();
                                categoria -= 1;

                                System.out.print("Capacidade de Pessoas: ");
                                int capacidade = scanner.nextInt();

                                carro = new Carro(id, tipoVeiculo, marca, modelo, anoFabricacao, valorDiaria, EnumCategoria.values()[categoria], capacidade, reservado, disponivel);

                                vetorAux[veiculos.length] = carro;

                                System.out.println("Veiculo cadastrado com Sucesso.\n");
                            }else if(opc == 2){

                                EnumIdVeiculo tipoVeiculo = EnumIdVeiculo.MOTO;

                                System.out.print("Cilindradas: ");
                                int cilindrada = scanner.nextInt();

                                moto = new Moto(id, tipoVeiculo, marca, modelo, anoFabricacao, valorDiaria, cilindrada, reservado, disponivel);

                                vetorAux[veiculos.length] = moto;

                                System.out.println("Veiculo cadastrado com Sucesso.");

                            }else {
                                System.out.println("Opção invalida!");
                            }

                            veiculos = vetorAux;

                        } else if (op == 5) {

                             Veiculo.reserva(veiculos);

                        }else if(op == 6){

                            if (clientes.length > 0 && veiculos.length > 0){
                                cliente.listarClientes(clientes);

                                Cliente clienteAluga = null;
                                Veiculo veiculoAluga = null;

                                while (true){
                                    System.out.print("Qual id do cliente: ");
                                    int idCliente = scanner.nextInt();

                                    for (int i = 0; i < clientes.length; i++) {

                                        if (idCliente == clientes[i].getId()) {
                                            clienteAluga = clientes[i];
                                            break;
                                        }else if(i == clientes.length - 1) {
                                            System.out.println("Cliente não encontrado");
                                        }
                                    }
                                    if(clienteAluga != null){
                                        break;
                                    }
                                }

                                Veiculo.listarFrota(veiculos);

                                while (true){
                                    System.out.print("Qual id do veiculo: ");
                                    int idVeiculo = scanner.nextInt();



                                    for (int i = 0; i < veiculos.length; i++) {
                                        if(idVeiculo == veiculos[i].getId()){
                                            veiculoAluga = veiculos[i];
                                            break;

                                        }else if(i == veiculos.length - 1){
                                            System.out.println("Veiculo não encontrado.");
                                        }
                                    }
                                    if(veiculoAluga != null){
                                        break;
                                    }
                                }

                                Aluguel aluguel = new Aluguel(clienteAluga, veiculoAluga);

                                aluguel.realizaAluguel();

                                System.out.println("Quantas diárias: ");
                                int diaria = scanner.nextInt();

                                System.out.println("Qual forma de pagamento: [1]PIX [2] CARTÃO [3]DINHEIRO");
                                int formaPagamento = scanner.nextInt();

                                System.out.printf("Valor a ser pago: R$ %.2f\n", aluguel.calcularValorAluguel(diaria, formaPagamento));

                            }else{
                                System.err.println("Opção Invalida.");
                            }

                        }else {
                            break;
                        }
                    }
                }

            }else if(op == 0){
                break;
            }else {
                System.err.println("Opção Invalida.");
            }
        }
    }
}