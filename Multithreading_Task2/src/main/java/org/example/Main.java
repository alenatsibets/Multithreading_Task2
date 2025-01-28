package org.example;


import org.example.port.Port;
import org.example.ship.Ship;
import org.example.ship.impl.LoadingShip;
import org.example.ship.impl.ProcessingShip;
import org.example.ship.impl.UnloadingShip;
import org.example.util.Factory;
import org.example.util.Warehouse;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ConfigLoader.PortConfig config =
                    ConfigLoader.loadConfig(Main.class.getClassLoader().getResource("config.json").getPath());

            Warehouse warehouse = new Warehouse(1000);
            Factory factory = new Factory(500);

            Port port = Port.getInstance();

            for (ConfigLoader.ShipConfig shipConfig : config.getShips()) {
                Ship ship = createShip(shipConfig, warehouse, factory);
                port.processShip(ship);
            }

            port.shutdown();

        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
        }
    }

    private static Ship createShip(ConfigLoader.ShipConfig shipConfig, Warehouse warehouse, Factory factory) {
        switch (shipConfig.getType()) {
            case "UnloadingShip":
                return new UnloadingShip(shipConfig.getName(), shipConfig.getCapacity(), warehouse);
            case "ProcessingShip":
                return new ProcessingShip(shipConfig.getName(), shipConfig.getCapacity(), factory);
            case "LoadingShip":
                return new LoadingShip(shipConfig.getName(), shipConfig.getCapacity(), factory);
            default:
                throw new IllegalArgumentException("Unknown ship type: " + shipConfig.getType());
        }
    }
}

