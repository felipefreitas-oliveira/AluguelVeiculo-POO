package br.com.cajazeiras.reservaveiculos.Interface;

import br.com.cajazeiras.reservaveiculos.Model.Cliente;

public interface IClientes {

    public Cliente[] cadastrar(Cliente[] clientes, Cliente cliente);

    public void listarClientes(Cliente[] clientes);

    public void atualizarCadastro(Cliente[] clientes, Cliente cliente);
}
