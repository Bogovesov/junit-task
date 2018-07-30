package com.mycompany.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Repository of drivers that work in-memory.
 */
public class InMemoryDriverRepository implements DriverRepository {

    private static Map<DriverId, Driver> storage;

    public InMemoryDriverRepository() {
        storage = new HashMap<>();
    }

    public Driver read(DriverId id) {
        Optional<DriverId> driverId = Optional.of(id);
        // return Optional
        if (storage.get(id) != null) {
            return storage.get(id);
        } else {
            return  storage.get(driverId);
        }
    }

    public void write(Driver driver) {
        storage.put(driver.getId(), driver);
    }
}
