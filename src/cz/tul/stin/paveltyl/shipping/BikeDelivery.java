package cz.tul.stin.paveltyl.shipping;

// Implementace dopravy na kole
public class BikeDelivery implements ShippingMethod { // Implementace rozhraní

    private static final double FIXED_PRICE = 80;     // Fixní cena
    private static final double MAX_WEIGHT = 5;       // Maximální povolená váha

    @Override
    public double calculateCost(double weight) {      // Výpočet ceny

        if (weight > MAX_WEIGHT) {                    // Kontrola váhového limitu
            throw new IllegalArgumentException(       // Vyhození výjimky
                    "Bike delivery supports max 5 kg" // Chybová zpráva
            );
        }

        return FIXED_PRICE;                           // Pokud je váha OK, vrací fixní cenu
    }
}
