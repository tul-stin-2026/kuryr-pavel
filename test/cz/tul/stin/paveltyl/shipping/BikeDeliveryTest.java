package cz.tul.stin.paveltyl.shipping;

// Import statických metod pro asserty.
import static org.junit.jupiter.api.Assertions.*;

// Import anotace @Test z JUnit 5.
import org.junit.jupiter.api.Test;

// Testovací třída pro BikeDelivery.
class BikeDeliveryTest {

    // Test ověřuje, že pro váhu pod limitem se vrátí fixní cena 80.
    @Test
    void shouldReturnFixedPriceForWeightBelowLimit() {

        // Vytvoření instance testované třídy.
        BikeDelivery bike = new BikeDelivery();

        // Ověření, že pro váhu 4.99 je cena 80.
        assertEquals(80, bike.calculateCost(4.99));
    }

    // Test ověřuje chování přesně na hranici povolené váhy.
    @Test
    void shouldReturnFixedPriceForWeightAtLimit() {

        // Vytvoření instance cyklodopravy.
        BikeDelivery bike = new BikeDelivery();

        // Ověření, že i pro přesnou hraniční hodnotu 5.0 je cena stále 80.
        assertEquals(80, bike.calculateCost(5.0));
    }

    // Test ověřuje, že při překročení limitu je vyhozena výjimka.
    @Test
    void shouldThrowExceptionForWeightAboveLimit() {

        // Vytvoření instance testované třídy.
        BikeDelivery bike = new BikeDelivery();

        // Ověření, že volání s váhou 5.01 vyhodí IllegalArgumentException.
        assertThrows(IllegalArgumentException.class,
                () -> bike.calculateCost(5.01));
    }

    // Test ověřuje chování pro nulovou váhu.
    @Test
    void shouldReturnFixedPriceForZeroWeight() {

        // Vytvoření instance cyklodopravy.
        BikeDelivery bike = new BikeDelivery();

        // Ověření, že i pro nulovou váhu je vrácena fixní cena 80.
        assertEquals(80, bike.calculateCost(0));
    }
}