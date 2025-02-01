package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConfigLoader {
    public static PortConfig loadConfig(String configFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(configFilePath), PortConfig.class);
    }

    public static class PortConfig {
        private List<ShipConfig> ships;

        public List<ShipConfig> getShips() {
            return ships;
        }

        public void setShips(List<ShipConfig> ships) {
            this.ships = ships;
        }
    }

    public static class ShipConfig {
        private String type;
        private String name;
        private int capacity;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }
    }
}
