package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);// This is to test, I am not sure where to add this yet

    private Dealership dealership;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();

    }

    public void display() {
        init();
        boolean run = true;
        System.out.println("=====Welcome to The Dealership==== \nPlease Make A Selection");
        while (run) {
            displayMenu();
            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    processAllVehiclesRequest();
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 99:
                    scanner.close();
                    run = false;
                    System.out.println("GoodBye!");
                    System.exit(0);
                    break;
            }
        }
    }

    public void displayMenu() {
        System.out.println("""
                  1 - Find vehicles within a price range
                  2 - Find vehicles by make / model
                  3 - Find vehicles by year range
                  4 - Find vehicles by color
                  5 - Find vehicles by mileage range
                  6 - Find vehicles by type (car, truck, SUV, van)
                  7 - List ALL vehicles
                  8 - Add a vehicle
                  9 - Remove a vehicle
                 99 - Quit
                """);

    }

    private void processAllVehiclesRequest() {
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }


}
