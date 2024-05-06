package br.com.cajazeiras.reservaveiculos.Enum;

public enum EnumAcesso {
    CADASTRAR_LOGIN(1),
    LOGIN(2),
    SAIR(0);

    public int value;

    EnumAcesso(int value){
        this.value = value;
    }
}
