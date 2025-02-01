package org.example.port;

import org.example.ship.Ship;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Port {
    public static final Port INSTANCE = new Port();


    public static Port getInstance() {
        return INSTANCE;
    }

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void processShip(Ship ship) {
        executorService.submit(ship);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
