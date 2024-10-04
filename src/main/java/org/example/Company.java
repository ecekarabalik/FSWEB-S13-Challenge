package org.example;

public class Company {
    private int id;
    private String name;
    private double giro;              // negatif olamaz
    private String[] developerNames;

    // Tüm alanları set eden constructor
    public Company(int id, String name, double giro, String[] developerNames) {
        this.id = id;
        this.name = name;
        setGiro(giro);                // kuralı tek yerden uygula
        this.developerNames = developerNames;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getGiro() { return giro; }
    public void setGiro(double giro) {
        if (giro < 0) {
            throw new IllegalArgumentException("giro negatif olamaz: " + giro);
        }
        this.giro = giro;
    }

    public String[] getDeveloperNames() { return developerNames; }
    public void setDeveloperNames(String[] developerNames) { this.developerNames = developerNames; }

    // developerNames[index] boşsa name yaz, doluysa uyar, aralık dışıysa uyar
    public void addEmployee(int index, String name) {
        if (developerNames == null) {
            System.out.println("developerNames dizisi tanımlı değil!");
            return;
        }
        if (index < 0 || index >= developerNames.length) {
            System.out.println("Geçersiz index: " + index + " (0-" + (developerNames.length - 1) + ") aralığında olmalı)");
            return;
        }
        if (developerNames[index] == null || developerNames[index].isEmpty()) {
            developerNames[index] = name;
            System.out.println("Çalışan eklendi: index=" + index + ", name=" + name);
        } else {
            System.out.println("Index zaten dolu: " + index + " (" + developerNames[index] + ")");
        }
    }

    @Override
    public String toString() {
        StringBuilder devs = new StringBuilder("[");
        if (developerNames != null) {
            for (int i = 0; i < developerNames.length; i++) {
                devs.append(developerNames[i]);
                if (i < developerNames.length - 1) devs.append(", ");
            }
        }
        devs.append("]");
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", giro=" + giro +
                ", developerNames=" + devs +
                '}';
    }
}