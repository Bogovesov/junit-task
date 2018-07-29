package com.mycompany.app;

/**
 * A paid ride made by driver.
 */
public class Ride {

    // Distance in kilometers.
    private int distance;

    public Ride(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
