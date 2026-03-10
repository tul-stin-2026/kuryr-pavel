package cz.tul.stin.paveltyl.shipping;

// Implementace letecké dopravy
public class AirDelivery implements ShippingMethod { // Implementuje rozhraní

    private static final double BASE_PRICE = 300;    // Vyšší základní cena
    private static final double PRICE_PER_KG = 25;   // Vyšší cena za kilogram

    @Override
    public double calculateCost(double weight) {     // Implementace výpočtu
        return BASE_PRICE + (PRICE_PER_KG * weight); // Výpočet ceny
    }
}
