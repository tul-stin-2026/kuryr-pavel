package cz.tulcz.stin.paveltyl.delivery;

import cz.tulcz.stin.paveltyl.shipping.ShippingMethod;

// Třída reprezentující zásilku
public class Delivery {                                 // Hlavní doménová třída

    private String trackingNumber;                      // Číslo zásilky
    private final double weight;                        // Váha zásilky
    private final ShippingMethod shippingMethod;        // Kompozice – zásilka má způsob dopravy

    public Delivery(String trackingNumber,              // Konstruktor
                    double weight,
                    ShippingMethod shippingMethod) {

        this.trackingNumber = trackingNumber;           // Uložení čísla
        this.weight = weight;                           // Uložení váhy
        this.shippingMethod = shippingMethod;           // Uložení typu dopravy
    }

    public double calculatePrice() {                    // Delegace výpočtu ceny
        return shippingMethod.calculateCost(weight);    // Polymorfní volání
    }
}

/*
// Upravená Delivery s Discount
// Rozšířená Delivery
public class Delivery {

    private String trackingNumber;                      // Číslo zásilky
    private double weight;                              // Váha
    private ShippingMethod shippingMethod;              // Kompozice
    private DiscountStrategy discountStrategy;          // Strategie slevy

    public Delivery(String trackingNumber,
                    double weight,
                    ShippingMethod shippingMethod,
                    DiscountStrategy discountStrategy) {

        this.trackingNumber = trackingNumber;
        this.weight = weight;
        this.shippingMethod = shippingMethod;
        this.discountStrategy = discountStrategy;
    }

    public double calculatePrice() {

        double basePrice = shippingMethod.calculateCost(weight); // Cena dopravy

        return discountStrategy.applyDiscount(basePrice);        // Aplikace slevy
    }
}
*/
