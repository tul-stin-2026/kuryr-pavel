package cz.tul.stin.paveltyl.delivery;

import cz.tul.stin.paveltyl.discount.DiscountStrategy;
import cz.tul.stin.paveltyl.shipping.ShippingMethod;

// Rozšířená třída Delivery reprezentující zásilku
public class Delivery {

    private final String trackingNumber;                      // Číslo zásilky
    private final double weight;                              // Váha
    private final ShippingMethod shippingMethod;              // Kompozice
    private final DiscountStrategy discountStrategy;          // Strategie slevy

    public Delivery(String trackingNumber,
                    double weight,
                    ShippingMethod shippingMethod,
                    DiscountStrategy discountStrategy) {

        this.trackingNumber = trackingNumber;
        this.weight = weight;
        this.shippingMethod = shippingMethod;
        this.discountStrategy = discountStrategy;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public double getWeight() {
        return weight;
    }

    public double calculatePrice() {

        double basePrice = shippingMethod.calculateCost(weight); // Cena dopravy

        return discountStrategy.applyDiscount(basePrice);        // Aplikace slevy
    }
}
