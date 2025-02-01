package org.example.ship.impl;

import org.example.ship.Ship;
import org.example.util.Factory;
import java.util.concurrent.TimeUnit;

public class LoadingShip extends Ship {
    public LoadingShip(String name, int capacity, Factory factory) {
        super(name, capacity, null, factory);
    }

    @Override
    public boolean performWork() {
        return loadResourcesFromFactory();
    }

    private boolean loadResourcesFromFactory() {
        int resourcesToLoad = this.capacity;

        try {
            logger.info(getName() + " is loading resources from the factory.");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
        return factory.sendToShip(resourcesToLoad);
    }
}
