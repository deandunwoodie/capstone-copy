package com.example.capstonebackend.enumeration;

public enum OutsideStateUseFactor {

    YES(1.1), NO(1.0);

    private double factorValue;

    OutsideStateUseFactor(final double factorValue) {
        this.factorValue = factorValue;
    }

    public double getFactorValue() {
        return factorValue;
    }
}
