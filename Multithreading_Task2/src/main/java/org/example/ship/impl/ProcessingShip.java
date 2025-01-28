package org.example.ship.impl;


import org.example.ship.Ship;
import org.example.util.Factory;

public class ProcessingShip extends Ship {

    public ProcessingShip(String name, int capacity, Factory factory) {
        super(name, capacity, null, factory);  // No warehouse for processing ships
    }

    @Override
    public boolean performWork() {
        return sendResourcesToFactory();
    }

    private boolean sendResourcesToFactory() {
        int resourcesForProcessing = this.capacity;
        return factory.processResources(resourcesForProcessing);
    }
}