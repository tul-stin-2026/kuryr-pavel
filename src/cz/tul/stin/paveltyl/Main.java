package cz.tul.stin.paveltyl;

import cz.tul.stin.paveltyl.delivery.Delivery;
import cz.tul.stin.paveltyl.discount.NoDiscount;
import cz.tul.stin.paveltyl.discount.PercentageDiscount;
import cz.tul.stin.paveltyl.shipping.*;

// Testovací třída
public class Main {

    static void main() {

        ShippingMethod truckMethod = new TruckDelivery();        // Základní doprava
        truckMethod = new ExpressDecorator(truckMethod);         // Přidání expresu
        truckMethod = new InsuranceDecorator(truckMethod);       // Přidání pojištění
        PercentageDiscount percentageDiscount = new PercentageDiscount(10);

        Delivery d1 = new Delivery(         // Vytvoření zásilky
                "CZ001",                    // Tracking number
                100,                         // Váha
                new TruckDelivery(),        // Konkrétní implementace
                new PercentageDiscount(10)
        );

        Delivery d2 = new Delivery(         // Druhá zásilka
                "CZ002",
                3,
                new BikeDelivery(),
                new NoDiscount()
        );

        Delivery d3 = new Delivery( // Třetí zásilka
                "CZ003",
                5,
                new AirDelivery(),
                new NoDiscount()
        );

        Delivery d4 = new Delivery(
                "CZ999",      // Číslo zásilky
                20,                        // Váha
                truckMethod,               // Dekorovaná doprava
                percentageDiscount         // 10% sleva
        );

        System.out.println("Truck (" + d1.getTrackingNumber() + ", " + d1.getWeight() + " kg ): " + d1.calculatePrice()); // Runtime polymorfismus
        System.out.println("Bike (" + d2.getTrackingNumber() + ", " + d2.getWeight() + " kg ): " + d2.calculatePrice());
        System.out.println("Air (" + d3.getTrackingNumber() + ", " + d3.getWeight() + " kg ): " + d3.calculatePrice());
        System.out.println("Truck Express s pojištěním (" + d4.getTrackingNumber() + ", " + d4.getWeight() + " kg ): " + d4.calculatePrice()); // Kompletní výpočet
    }
}