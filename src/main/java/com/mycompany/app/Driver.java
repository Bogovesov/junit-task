package com.mycompany.app;

/**
 * Represents our client and drives a cab.
 */
public class Driver {

    private DriverId id;

    private double coefficient = 1;

    public DriverId getId() {
        return id;
    }

    public void setId(DriverId id) {
        this.id = id;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }


}
