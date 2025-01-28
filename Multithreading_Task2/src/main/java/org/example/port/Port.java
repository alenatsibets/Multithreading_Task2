package org.example.port;

import org.example.ship.Ship;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Port {

    private Port() {
    }

    private static class PortSingletonHelper {
        private static final Port INSTANCE = new Port();
    }

    public static Port getInstance() {
        return PortSingletonHelper.INSTANCE;
    }

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void processShip(Ship ship) {
        executorService.submit(ship);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
