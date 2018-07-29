package com.mycompany.app;

/**
 * Obtains drivers from database and stores them there.
 */
public interface DriverRepository {

    Driver read(DriverId id);

    void write(Driver driver);
}
