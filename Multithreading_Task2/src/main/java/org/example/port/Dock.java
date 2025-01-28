package org.example.port;

import org.example.ship.Ship;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Dock {
    private final Lock lock = new ReentrantLock();

    public boolean dockShip(Ship ship) {
        lock.lock();
        try {
            System.out.println("Ship " + ship.getName() + " is docking.");
            return true;
        } finally {
            lock.unlock();
        }
    }
}
