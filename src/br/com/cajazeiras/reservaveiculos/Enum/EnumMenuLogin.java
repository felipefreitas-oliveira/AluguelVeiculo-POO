package br.com.cajazeiras.reservaveiculos.Enum;

public enum EnumMenuLogin {
    CADASTRAR_CLIENTE(1),
    ATUALIZAR_CADASTRO(2),
    LISTAR_CLIENTES(3),
    CADASTRAR_VEICULO(4),
    FROTA(5),
    ALUGAR(6),
    SAIR(0);

    public int value;

    EnumMenuLogin(int value){
        this.value = value;
    }
}
