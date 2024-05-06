package br.com.cajazeiras.reservaveiculos.Enum;

public enum EnumCategoria {
    ECONOMICO(1),
    SEDAN(2),
    SUV(3),
    EXECUTIVO(4);

    public int value;

    EnumCategoria(int value){
        this.value = value;
    }
}
