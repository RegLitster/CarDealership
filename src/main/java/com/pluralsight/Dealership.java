package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String dealershipName;
    private String dealershipAddress;
    private String dealershipPhone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String dealershipName, String dealershipAddress, String dealershipPhone, ArrayList<Vehicle> inventory) {
        this.dealershipName = dealershipName;
        this.dealershipAddress = dealershipAddress;
        this.dealershipPhone = dealershipPhone;
        this.inventory = inventory;
    }

    public ArrayList<Vehicle> getVehiclesByPrice() {
        return null;

    }

    public ArrayList<Vehicle> getVehiclesByMakeModel() {
        return null;

    }

    public ArrayList<Vehicle> getVehiclesByYear() {
        return null;

    }

    public ArrayList<Vehicle> getVehiclesByColor() {
        return null;

    }

    public ArrayList<Vehicle> getVehiclesByMileage() {
        return null;

    }

    public ArrayList<Vehicle> getVehiclesByType() {
        return null;

    }

    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;

    }

    public Vehicle addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
        return vehicle;
    }

    public Vehicle removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
        return null;
    }

    public String toString() {
        return dealershipName + " " + dealershipAddress + " " + dealershipPhone;
    }
}