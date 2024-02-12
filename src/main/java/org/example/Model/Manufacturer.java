package org.example.Model;
import java.util.Objects;

public class Manufacturer {
    public String manufacturerName;
    public Manufacturer(){

        }

        public Manufacturer(String name) {
            this.manufacturerName = manufacturerName;
        }

        public String getManufacturerName() {
            return manufacturerName;
        }

        public void setName(String manufacturerName) {
            this.manufacturerName = manufacturerName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Manufacturer manufacturer = (Manufacturer) o;
            return Objects.equals(manufacturerName, manufacturer.manufacturerName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(manufacturerName);
        }

        @Override
        public String toString() {
            return "Manufacturer{" +
                    "name='" + manufacturerName + '\'' +
                    '}';
        }
    }

