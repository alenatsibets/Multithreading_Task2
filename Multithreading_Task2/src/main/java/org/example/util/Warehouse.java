package org.example.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.ReentrantLock;


public class Warehouse {
    private static final Logger logger = LogManager.getLogger();
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
                logger.info("Unloaded " + resources + " units to the warehouse.");
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
            logger.info("Loaded " + resources + " units from the warehouse.");
        } finally {
            lock.unlock();
        }
    }
}
