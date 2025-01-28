package org.example.ship.impl;

import org.example.ship.Ship;
import org.example.util.Factory;

public class LoadingShip extends Ship {

    public LoadingShip(String name, int capacity, Factory factory) {
        super(name, capacity, null, factory);  // No warehouse for loading ships
    }

    @Override
    public boolean performWork() {
        return loadResourcesFromFactory();
    }

    private boolean loadResourcesFromFactory() {
        int resourcesToLoad = this.capacity;
        return factory.sendToShip(resourcesToLoad);
    }
}