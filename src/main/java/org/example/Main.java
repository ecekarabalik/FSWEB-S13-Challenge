package org.example;

import org.example.enums.Plan;

public class Main {
    public static void main(String[] args) {
        runDemo();
    }

    // Tüm işlemler bu metotta (Görev 3)
    public static void runDemo() {
        // --- Company ---
        String[] devs = new String[3];
        Company company = new Company(1, "Workintech", 1_000_000, devs);
        System.out.println("Company (ilk): " + company);

        company.addEmployee(0, "Ece");
        company.addEmployee(1, "Ali");
        company.addEmployee(1, "Deneme Dolu");       // dolu uyarısı
        company.addEmployee(5, "AralikDisi");        // aralık dışı uyarısı
        System.out.println("Company (son): " + company);

        // Getter/Setter kullanım örnekleri (uyarıları da azaltır)
        int eskiId = company.getId();
        company.setId(2);
        company.setName("Workintech A.Ş.");
        company.setDeveloperNames(new String[]{"Ece", "Ali", "Ayşe"});
        System.out.println("Company id (eski->yeni): " + eskiId + " -> " + company.getId());
        System.out.println("Company adı: " + company.getName());
        System.out.println("Company giro: " + company.getGiro());

        try {
            company.setGiro(-5); // beklenen hata
        } catch (IllegalArgumentException ex) {
            System.out.println("Beklenen hata: " + ex.getMessage());
        }

        // --- Employee ---
        String[] empHealthArr = new String[2];
        Employee emp = new Employee(100, "Ece Karabalık", "ece@example.com", "secret", empHealthArr);
        System.out.println("Employee (ilk): " + emp);

        emp.addHealthplan(0, Plan.BASIC.getName());   // başarı
        emp.addHealthplan(1, Plan.PREMIUM.getName()); // başarı
        emp.addHealthplan(1, "STANDARD");             // dolu uyarısı
        emp.addHealthplan(3, "GEÇERSİZ");             // aralık dışı uyarısı
        System.out.println("Employee (son): " + emp);

        // --- Healthplan ---
        Healthplan hp1 = new Healthplan(10, "Çalışan Sağlık", Plan.BASIC);
        Healthplan hp2 = new Healthplan(20, "Yönetici Sağlık", Plan.PREMIUM);
        System.out.println(hp1);
        System.out.println(hp2);
    }
}