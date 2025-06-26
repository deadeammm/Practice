package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Задание 1: Массивы ---");
        task1();
        System.out.println("\n--- Задание 2: Коллекции ---");
        task2();
        System.out.println("\n--- Задание 3: equals/hashCode и Comparable (Сравнение автомобилей) ---");
        task3();
        System.out.println("\n--- Задание 4: Stream API ---");
        task4();
    }

    // Задание 1: Массивы (Работа с парком машин)
    private static void task1() {
        int[] years = new int[50];
        Random random = new Random();
        int currentYear = 2025;
        int sumAge = 0;

        for (int i = 0; i < years.length; i++) {
            years[i] = random.nextInt(2000, 2026);
        }

        System.out.println("Машины после 2015 года:");
        for (int year : years) {
            if (year > 2015) {
                System.out.print(year + " ");
            }
            sumAge += (currentYear - year);
        }
        System.out.println();

        double avgAge = (double) sumAge / years.length;
        System.out.printf("Средний возраст авто: %.2f%n", avgAge);
    }

    // Задание 2: Коллекции (Управление моделями)
    private static void task2() {
        List<String> models = Arrays.asList(
                "Camry", "X5", "A4", "Model 3",
                "X5", "Camry", "Model S"
        );

        Set<String> uniqueModels = new TreeSet<>(Collections.reverseOrder());
        for (String model : models) {
            if (model.contains("Model")) {
                uniqueModels.add("ELECTRO_CAR");
            } else {
                uniqueModels.add(model);
            }
        }

        System.out.println("Уникальные модели (обратно):");
        uniqueModels.forEach(System.out::println);
    }

    // Задание 3: equals/hashCode и Comparable
    private static void task3() {
        Set<Car> carSet = new HashSet<>();

        carSet.add(new Car("1A", "X5", "BMW", 2020, 0, 0));
        carSet.add(new Car("1A", "X5", "BMW", 2020, 0, 0));
        carSet.add(new Car("2B", "A4", "Audi", 2022, 0, 0));

        System.out.println("Размер HashSet (без дубликатов): " + carSet.size());

        List<Car> sortedCars = new ArrayList<>(carSet);
        Collections.sort(sortedCars);
        System.out.println("Отсортированные машины по году (новые -> старые):");
        sortedCars.forEach(System.out::println);
    }

    // Задание 4: Stream API (Анализ автопарка)
    private static void task4() {
        List<Car> cars = List.of(
                new Car("1", "3 Series", "BMW", 2023, 30000, 55000),
                new Car("2", "Camry", "Toyota", 2020, 60000, 30000),
                new Car("3", "A4", "Audi", 2022, 40000, 45000),
                new Car("4", "Model 3", "Tesla", 2024, 10000, 70000),
                new Car("5", "Model S", "Tesla", 2023, 20000, 65000)
        );

        // Фильтрация пробега < 50000
        List<Car> filtered = cars.stream()
                .filter(c -> c.getMileage() < 50000)
                .collect(Collectors.toList());

        // Сортировка по цене убыв.
        List<Car> sorted = filtered.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .toList();

        System.out.println("Топ-3 дорогие машины:");
        sorted.stream().limit(3).forEach(System.out::println);

        double avgMileage = cars.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0);
        System.out.printf("Средний пробег: %.1f%n", avgMileage);

        Map<String, List<Car>> byBrand = cars.stream()
                .collect(Collectors.groupingBy(Car::getBrand));
        System.out.println("Группировка по брендам:");
        byBrand.forEach((brand, list) -> System.out.println(brand + ": " + list.size()));
    }

    static class Car implements Comparable<Car> {
        private String vin;
        private String model;
        private String brand;
        private int year;
        private int mileage;
        private double price;

        public Car(String vin, String model, String brand, int year, int mileage, double price) {
            this.vin = vin;
            this.model = model;
            this.brand = brand;
            this.year = year;
            this.mileage = mileage;
            this.price = price;
        }

        public String getVin() { return vin; }
        public String getModel() { return model; }
        public String getBrand() { return brand; }
        public int getYear() { return year; }
        public int getMileage() { return mileage; }
        public double getPrice() { return price; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Car car)) return false;
            return vin.equals(car.vin);
        }

        @Override
        public int hashCode() {
            return vin.hashCode();
        }

        @Override
        public int compareTo(Car other) {
            return Integer.compare(other.year, this.year);
        }

        @Override
        public String toString() {
            return String.format("%s %s (%d, VIN=%s)", brand, model, year, vin);
        }
    }
}
