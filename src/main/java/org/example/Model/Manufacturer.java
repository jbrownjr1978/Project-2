package org.example.Model;
import java.util.Objects;

public class Manufacturer {
    public String name;
    public Manufacturer(){

        }

        public Manufacturer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Manufacturer manufacturer = (Manufacturer) o;
            return Objects.equals(name, manufacturer.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Manufacturer{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

