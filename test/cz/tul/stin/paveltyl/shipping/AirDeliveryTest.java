package cz.tul.stin.paveltyl.shipping;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// black-box
// výpočet podle specifikace
// Stejný princip jako u TruckDelivery
// Testujeme vzorec 300 + 25 * weight pouze na základě zadání, bez znalosti implementace.
// Testovací třída pro AirDelivery.
class AirDeliveryTest {

    // Test ověřuje výpočet ceny pro běžnou váhu.
    @Test
    void shouldCalculatePriceForStandardWeight() {

        // Vytvoření instance letecké dopravy.
        AirDelivery air = new AirDelivery();

        // Výpočet:
        // 300 + 25 * 5 = 425
        assertEquals(425, air.calculateCost(5));
    }

    // Test ověřuje cenu při nulové váze.
    @Test
    void shouldReturnBasePriceForZeroWeight() {

        // Vytvoření instance letecké dopravy.
        AirDelivery air = new AirDelivery();

        // Pro nulovou váhu se vrací jen základní cena 300.
        assertEquals(300, air.calculateCost(0));
    }

    // Test ověřuje výpočet pro desetinnou váhu.
    @Test
    void shouldCalculatePriceForDecimalWeight() {

        // Vytvoření instance letecké dopravy.
        AirDelivery air = new AirDelivery();

        // Výpočet:
        // 300 + 25 * 2.5 = 362.5
        assertEquals(362.5, air.calculateCost(2.5));
    }
}