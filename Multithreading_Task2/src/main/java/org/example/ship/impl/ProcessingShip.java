package org.example.ship.impl;

import org.example.ship.Ship;
import org.example.util.Factory;
import java.util.concurrent.TimeUnit;

public class ProcessingShip extends Ship {

    public ProcessingShip(String name, int capacity, Factory factory) {
        super(name, capacity, null, factory);
    }

    @Override
    public boolean performWork() {
        return sendResourcesToFactory();
    }

    private boolean sendResourcesToFactory() {
        int resourcesForProcessing = this.capacity;

        try {
            logger.info(getName() + " is sending resources to the factory for processing.");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
        return factory.processResources(resourcesForProcessing);
    }
}
