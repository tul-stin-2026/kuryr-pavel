package cz.tulcz.stin.paveltyl;

import cz.tulcz.stin.paveltyl.delivery.Delivery;
import cz.tulcz.stin.paveltyl.shipping.AirDelivery;
import cz.tulcz.stin.paveltyl.shipping.BikeDelivery;
import cz.tulcz.stin.paveltyl.shipping.TruckDelivery;

// Testovací třída
public class Main {

    public static void main(String[] args) {

        Delivery d1 = new Delivery( // Vytvoření zásilky
                "CZ001",            // Tracking number
                10,                 // Váha
                new TruckDelivery() // Konkrétní implementace
        );

        Delivery d2 = new Delivery( // Druhá zásilka
                "CZ002",
                3,
                new BikeDelivery()
        );

        Delivery d3 = new Delivery( // Třetí zásilka
                "CZ003",
                5,
                new AirDelivery()
        );

        System.out.println("Truck: " + d1.calculatePrice()); // Runtime polymorfismus
        System.out.println("Bike: " + d2.calculatePrice());
        System.out.println("Air: " + d3.calculatePrice());
    }
}