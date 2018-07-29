package com.mycompany.app;

import java.util.Set;

import static java.time.ZonedDateTime.now;

/**
 * Calculates how much money and when we pay to drivers.
 *
 * @author Vladyslav Lubenskyi
 */
public class PaymentCalculator {

    final private DriverRepository driverRepository;

    public PaymentCalculator(DriverRepository repository) {
        this.driverRepository = repository;
    }

    /**
     * Calculates payment for a single ride for the given driver.
     */
    public Payment calculate(Ride ride, DriverId id) {
        Driver driver = driverRepository.read(id);
        double sum = calculateMoney(ride, driver);
        return new Payment((int) sum, now());
    }

    /**
     * Calculates payment for multiple rides at once for the given.
     */
    public Payment calculate(Set<Ride> rides, DriverId id) {
        Driver driver = driverRepository.read(id);
        double sum = 0;
        for (Ride ride : rides) {
            sum += calculateMoney(ride, driver);
        }
        return new Payment((int) sum, now());
    }

    private double calculateMoney(Ride ride, Driver driver) {
        return ride.getDistance() * driver.getCoefficient();
    }
}
