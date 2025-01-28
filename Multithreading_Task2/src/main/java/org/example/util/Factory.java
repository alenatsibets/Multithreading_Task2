package org.example.util;

import java.util.concurrent.locks.ReentrantLock;

public class Factory {
    private int capacity;
    private final ReentrantLock lock = new ReentrantLock();

    public Factory(int capacity) {
        this.capacity = capacity;
    }

    public boolean processResources(int resources) {
        lock.lock();
        try {
            if (resources <= capacity) {
                capacity -= resources;
                System.out.println("Processed " + resources + " units in the factory.");
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public boolean sendToShip(int resources) {
        lock.lock();
        try {
            capacity += resources;
            System.out.println("Sent " + resources + " units back to the ship.");
            return true;
        } finally {
            lock.unlock();
        }
    }
}
