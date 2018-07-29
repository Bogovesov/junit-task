package com.mycompany.app;

import java.util.HashMap;
import java.util.Map;

/**
 * Repository of drivers that work in-memory.
 */
public class InMemoryDriverRepository implements DriverRepository {

    private static Map<DriverId, Driver> storage;

    public InMemoryDriverRepository(){
        storage = new HashMap<>();
    }

    public Driver read(DriverId id) {
        // return Optional
        return storage.get(id);
    }

    public void write(Driver driver) {
        storage.put(driver.getId(), driver);
    }
}
