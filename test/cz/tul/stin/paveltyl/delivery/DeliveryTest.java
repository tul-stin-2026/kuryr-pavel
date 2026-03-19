package cz.tul.stin.paveltyl.delivery;

import cz.tul.stin.paveltyl.discount.NoDiscount;
import cz.tul.stin.paveltyl.shipping.AirDelivery;
import cz.tul.stin.paveltyl.shipping.BikeDelivery;
import cz.tul.stin.paveltyl.shipping.TruckDelivery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// black-box (integrační)
// delegace na ShippingMethod
// Testujeme, že Delivery správně deleguje výpočet na zvolenou implementaci dopravy.
// Testovací třída pro hlavní doménovou třídu Delivery.
class DeliveryTest {

    // Test ověřuje, že Delivery správně používá TruckDelivery.
    @Test
    void shouldUseTruckDelivery() {

        // Vytvoření zásilky s váhou 10 kg a kamionovou dopravou.
        Delivery d = new Delivery("CZ001", 10, new TruckDelivery(), new NoDiscount());

        // Delivery má delegovat výpočet na TruckDelivery.
        // Očekávaná cena je 200.
        assertEquals(200, d.calculatePrice());
    }

    // Test ověřuje použití letecké dopravy.
    @Test
    void shouldUseAirDelivery() {

        // Vytvoření zásilky s leteckou dopravou.
        Delivery d = new Delivery("CZ002", 5, new AirDelivery(), new NoDiscount());

        // Delivery má vrátit cenu spočtenou AirDelivery.
        assertEquals(425, d.calculatePrice());
    }

    // Test ověřuje použití cyklodopravy.
    @Test
    void shouldUseBikeDelivery() {

        // Vytvoření zásilky s cyklodopravou.
        Delivery d = new Delivery("CZ003", 3, new BikeDelivery(), new NoDiscount());

        // Pro váhu 3 kg se vrací fixní cena 80.
        assertEquals(80, d.calculatePrice());
    }

    // Test ověřuje, že výjimka z BikeDelivery projde přes Delivery dál.
    @Test
    void shouldPropagateExceptionFromBikeDelivery() {

        // Vytvoření zásilky s nepovolenou váhou pro kolo.
        Delivery d = new Delivery("CZ004", 6, new BikeDelivery(), new NoDiscount());

        // Ověření, že calculatePrice() skutečně vyhodí výjimku.
        assertThrows(IllegalArgumentException.class, d::calculatePrice);
    }
}