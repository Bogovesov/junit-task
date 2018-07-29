package com.mycompany.app;

import java.time.ZonedDateTime;

/**
 * A payment to be made to a driver.
 */
public class Payment {

    private final int money;

    private final ZonedDateTime dateTime;

    public Payment(int money, ZonedDateTime dateTime) {
        this.dateTime = dateTime;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }
}
