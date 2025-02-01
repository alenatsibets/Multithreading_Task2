package org.example.port;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.ship.Ship;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Dock {
    private final Lock lock = new ReentrantLock();
    private static final Logger logger = LogManager.getLogger();

    public boolean dockShip(Ship ship) {
        lock.lock();
        try {
            logger.info("Ship " + ship.getName() + " is docking.");
            return true;
        } finally {
            lock.unlock();
        }
    }
}
