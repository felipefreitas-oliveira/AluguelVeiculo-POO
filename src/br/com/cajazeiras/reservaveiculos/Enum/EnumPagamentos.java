package br.com.cajazeiras.reservaveiculos.Enum;

public enum EnumPagamentos {
    PIX(1),
    CARTAO(2),
    DINHEIRO(3);

    public int value;

    EnumPagamentos(int value){this.value = value;}
}