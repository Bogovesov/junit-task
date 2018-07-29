package com.mycompany.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.mycompany.app.DriverId.create;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("InMemoryDriverRepository should")
public class InMemoryDriverRepositoryTest {

    public static final long DIRVER_ID = 1L;

    @Test
    @DisplayName("store driver in memory ")
    void storeDriverInMemory() {
        DriverId driverId = create(DIRVER_ID);
        Driver driver = new Driver();
        driver.setId(driverId);

        InMemoryDriverRepository repository = new InMemoryDriverRepository();
        repository.write(driver);

        assertNotNull(repository.read(driverId));
        assertEquals(repository.read(driverId), driver);
        assertEquals(DIRVER_ID, driver.getId().getValue());
    }
}
