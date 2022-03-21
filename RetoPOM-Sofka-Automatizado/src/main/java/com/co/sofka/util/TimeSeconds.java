package com.co.sofka.util;

public enum TimeSeconds {
    CERO_SEGUNDOS(0),
    UN_SEGUNDO(1),
    DOS_SEGUNDOS(2),
    TRES_SEGUNDOS(3),
    CUATRO_SEGUNDOS(4),
    CINCO_SEGUNDOS(5),
    DIEZ_SEGUNDOS(10);


    private final int value;

    TimeSeconds(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
