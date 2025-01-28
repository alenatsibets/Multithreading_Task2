package org.example.util;

import java.util.concurrent.locks.ReentrantLock;


public class Warehouse {
    private int capacity;
    private final ReentrantLock lock = new ReentrantLock();

    public Warehouse(int capacity) {
        this.capacity = capacity;
    }

    public boolean unloadResources(int resources) {
        lock.lock();
        try {
            if (resources <= capacity) {
                capacity -= resources;
                System.out.println("Unloaded " + resources + " units to the warehouse.");
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public void loadResources(int resources) {
        lock.lock();
        try {
            capacity += resources;
            System.out.println("Loaded " + resources + " units from the warehouse.");
        } finally {
            lock.unlock();
        }
    }
}
