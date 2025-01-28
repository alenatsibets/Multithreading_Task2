package org.example.ship.impl;


import org.example.ship.Ship;
import org.example.util.Warehouse;

public class UnloadingShip extends Ship {

    public UnloadingShip(String name, int capacity, Warehouse warehouse) {
        super(name, capacity, warehouse, null);  // No factory for unloading ships
    }

    @Override
    public boolean performWork() {
        return unloadResourcesToWarehouse();
    }

    private boolean unloadResourcesToWarehouse() {
        int resourcesToUnload = this.capacity;
        return warehouse.unloadResources(resourcesToUnload);
    }
}