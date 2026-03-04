package cz.tulcz.stin.paveltyl;

// Implementace dopravy kamionem
public class TruckDelivery implements ShippingMethod {   // Třída implementuje rozhraní

    private static final double BASE_PRICE = 100;        // Základní cena dopravy
    private static final double PRICE_PER_KG = 10;       // Cena za kilogram

    @Override
    public double calculateCost(double weight) {         // Implementace výpočtu ceny
        return BASE_PRICE + (PRICE_PER_KG * weight);     // Základ + cena za váhu
    }
}
