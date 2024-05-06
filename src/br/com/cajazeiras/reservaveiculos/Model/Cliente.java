package br.com.cajazeiras.reservaveiculos.Model;

import java.util.Scanner;

public class Cliente extends Pessoa{
    public Cliente(){}

    public Cliente(int id, String nome, String telefone, Endereco endereco) {

        super(id, nome, telefone, endereco);
    }

    public static Cliente[] cadastrar(Cliente[] clientes, Cliente cliente){
        Cliente[] novoVetorClientes = new Cliente[clientes.length + 1];

        for (int i = 0; i < clientes.length; i++){
            novoVetorClientes[i] = clientes[i];
        }
        System.out.println("Cliente " + (clientes.length + 1) + ":");
        int id = clientes.length + 1;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Numero: ");
        String numero = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        cliente = new Cliente(id, nome, telefone, new Endereco(rua, numero, bairro, cidade));

        novoVetorClientes[clientes.length] = cliente;

        clientes = novoVetorClientes;

        System.out.println("Cadastro realizado com sucesso.\n");
        return clientes;
    }

    public static void listarClientes(Cliente[] clientes){
        if(clientes.length > 0){
            for (int i = 0; i < clientes.length; i++) {
                Cliente cliente1 = clientes[i];
                System.out.println("Cliente " + (cliente1.getId()) + ":");
                System.out.println("Nome: " + cliente1.nome);
                System.out.println("Endereço " + cliente1.endereco);
                System.out.printf("Telefone: %s\n\n", cliente1.telefone);
            }
        }else {
            System.out.println("Nenhum cliente encontrado");
        }
    }

    public static void atualizarCadastro(Cliente[] clientes, Cliente cliente){

        Scanner scanner = new Scanner(System.in);

        if(clientes.length > 0) {

            listarClientes(clientes);

            System.out.print("Qual id do cliente deseja atualizar: ");
            int idCliente = scanner.nextInt();

            for (int i = 0; i < clientes.length; i++) {
                if (idCliente == clientes[i].getId()) {
                    System.out.println("Cliente " + (idCliente) + ":");

                    scanner = new Scanner(System.in);

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Rua: ");
                    String rua = scanner.nextLine();
                    System.out.print("Numero: ");
                    String numero = scanner.nextLine();
                    System.out.print("Bairro: ");
                    String bairro = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();

                    scanner = new Scanner(System.in);

                    clientes[idCliente - 1] = new Cliente(idCliente, nome, telefone, new Endereco(rua, numero, bairro, cidade));

                    System.out.println("Cadastro atualizado com sucesso");
                }
            }
        }
    }


}