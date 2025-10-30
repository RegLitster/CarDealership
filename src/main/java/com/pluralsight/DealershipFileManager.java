package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DealershipFileManager {

    public Dealership getDealership() {

        Dealership dealership = null;
        try (BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))) {

            bufReader.readLine();
            String[] dealershipInfo = bufReader.readLine().split("\\|");
            String dealershipName = dealershipInfo[0];
            String dealershipAddress = dealershipInfo[1];
            String dealershipPhone = dealershipInfo[2];


            ArrayList<Vehicle> vehicles = new ArrayList<>();
            String line;
            while ((line = bufReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length < 8) continue;

                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicles.add(vehicle);
            }

            dealership = new Dealership(dealershipName, dealershipAddress, dealershipPhone, vehicles);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading file" + e.getMessage());
        }
        return dealership;
    }

    public Dealership saveDealership(Dealership dealership) {
        return null;
    }
}
