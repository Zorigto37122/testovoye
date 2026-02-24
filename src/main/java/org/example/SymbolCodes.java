package org.example;

public enum SymbolCodes {
    WI(0, "WI"),
    H1(1, "H1"),
    M1(2, "M1"),
    M2(3, "M2"),
    M3(4, "M3"),
    L1(5, "L1"),
    L2(6, "L2"),
    L3(7, "L3"),
    L4(8, "L4"),
    EM(9, "EM");

    private final int code;
    private final String name;

    SymbolCodes(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}