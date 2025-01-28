package org.example.ship;


import org.example.util.Factory;
import org.example.util.Warehouse;

import java.util.concurrent.Callable;

public abstract class Ship implements Callable<Boolean> {
    protected final String name;
    protected final int capacity;
    protected final Warehouse warehouse;
    protected final Factory factory;

    public Ship(String name, int capacity, Warehouse warehouse, Factory factory) {
        this.name = name;
        this.capacity = capacity;
        this.warehouse = warehouse;
        this.factory = factory;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public abstract boolean performWork();

    @Override
    public Boolean call() {
        System.out.println(name + " starts its operation.");
        boolean success = performWork();
        if (success) {
            System.out.println(name + " successfully completed its task.");
        }
        return success;
    }
}
