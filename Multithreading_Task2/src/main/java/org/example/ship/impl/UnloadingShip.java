package org.example.ship.impl;

import org.example.ship.Ship;
import org.example.util.Warehouse;
import java.util.concurrent.TimeUnit;

public class UnloadingShip extends Ship {

    public UnloadingShip(String name, int capacity, Warehouse warehouse) {
        super(name, capacity, warehouse, null);
    }

    @Override
    public boolean performWork() {
        return unloadResourcesToWarehouse();
    }

    private boolean unloadResourcesToWarehouse() {
        int resourcesToUnload = this.capacity;

        try {
            logger.info(getName() + " is unloading resources to the warehouse.");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
        return warehouse.unloadResources(resourcesToUnload);
    }
}
