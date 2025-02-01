package org.example.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.ReentrantLock;

public class Factory {
    private static final Logger logger = LogManager.getLogger();
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
                logger.info("Processed " + resources + " units in the factory.");
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
            logger.info("Sent " + resources + " units back to the ship.");
            return true;
        } finally {
            lock.unlock();
        }
    }
}
