package com.mycompany.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static com.mycompany.app.DriverId.create;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("PaymentCalculator should")
class PaymentCalculatorTest {

    private static final int HUNDRED_KM = 100;
    private static final int THOUSAND_KM = HUNDRED_KM * 10;
    private static final int FIFTY_KM = 50;
    private static final double COEFFICIENT = 1.5;

    @Test
    @DisplayName("calculate payment for a single ride")
    void calculatePaymentForSingleRide() {
        Ride ride = new Ride(HUNDRED_KM);
        DriverId driverId = create(1L);

        PaymentCalculator calculator =
                new PaymentCalculator(mockRepository(driverId));
        Payment payment = calculator.calculate(ride, driverId);

        assertNotNull(payment);
        assertNotNull(payment.getDateTime());
        assertEquals(COEFFICIENT * HUNDRED_KM, payment.getMoney());

        ride.setDistance(THOUSAND_KM);
        payment = calculator.calculate(ride, driverId);
        assertEquals(COEFFICIENT * THOUSAND_KM, payment.getMoney());
    }

    @Test
    @DisplayName("calculate payment for multiple rides")
    void calculatePaymentForMultipleRides() {
        Ride ride1 = new Ride(HUNDRED_KM);
        Ride ride2 = new Ride(FIFTY_KM);
        DriverId driverId = create(1L);

        HashSet<Ride> rides = new HashSet<>();
        rides.add(ride1);
        rides.add(ride2);

        PaymentCalculator calculator =
                new PaymentCalculator(mockRepository(driverId));
        Payment payment = calculator.calculate(rides, driverId);

        assertNotNull(payment);
        assertNotNull(payment.getDateTime());
        assertEquals(COEFFICIENT * (HUNDRED_KM + FIFTY_KM),
                payment.getMoney());

    }

    private DriverRepository mockRepository(DriverId driverId) {
        Driver driver = new Driver();
        driver.setId(driverId);
        driver.setCoefficient(COEFFICIENT);

        DriverRepository mock = mock(DriverRepository.class);

        when(mock.read(any())).thenReturn(driver);
        return mock;
    }
}
