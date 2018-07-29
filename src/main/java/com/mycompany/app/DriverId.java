package com.mycompany.app;

/**
 * Unique identifier of a driver.
 */
public final class DriverId {

    private final long value;

    private DriverId(long value) {
        this.value = value;
    }

    public static DriverId create(long value) {
        return new DriverId(value);
    }

    public long getValue() {
        return value;
    }
}
