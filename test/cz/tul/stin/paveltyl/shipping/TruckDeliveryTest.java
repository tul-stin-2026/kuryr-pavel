package cz.tul.stin.paveltyl.shipping;

// Import anotace @Test.
import org.junit.jupiter.api.Test;

// Import statických metod assertEquals.
import static org.junit.jupiter.api.Assertions.*;

// Testovací třída pro TruckDelivery.
class TruckDeliveryTest {

    // Test ověřuje běžný výpočet ceny pro standardní váhu.
    @Test
    void shouldCalculatePriceForStandardWeight() {

        // Vytvoření instance kamionové dopravy.
        TruckDelivery truck = new TruckDelivery();

        // Ověření výpočtu:
        // 100 + 10 * 10 = 200
        assertEquals(200, truck.calculateCost(10));
    }

    // Test ověřuje cenu pro nulovou váhu.
    @Test
    void shouldCalculateBasePriceForZeroWeight() {

        // Vytvoření instance testované třídy.
        TruckDelivery truck = new TruckDelivery();

        // Pro nulovou váhu se vrací jen základní cena 100.
        assertEquals(100, truck.calculateCost(0));
    }

    // Test ověřuje, že výpočet funguje i pro desetinnou váhu.
    @Test
    void shouldCalculatePriceForDecimalWeight() {

        // Vytvoření instance kamionové dopravy.
        TruckDelivery truck = new TruckDelivery();

        // Výpočet:
        // 100 + 10 * 2.5 = 125
        assertEquals(125, truck.calculateCost(2.5));
    }

    // Test ukazuje, že aktuální implementace nevaliduje zápornou váhu.
    @Test
    void shouldRevealMissingValidationForNegativeWeight() {

        // Vytvoření instance kamionové dopravy.
        TruckDelivery truck = new TruckDelivery();

        // Výpočet:
        // 100 + 10 * (-1) = 90
        // Test tím neříká, že je to doménově správně,
        // ale ukazuje skutečné chování implementace.
        assertEquals(90, truck.calculateCost(-1));
    }
}