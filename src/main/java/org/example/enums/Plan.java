package org.example.enums;


public enum Plan {
    BASIC("Basic", 0.0),
    STANDARD("Standard", 49.99),
    PREMIUM("Premium", 99.99);


    private final String name;
    private final double price;


    Plan(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Plan{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
