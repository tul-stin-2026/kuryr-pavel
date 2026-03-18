package cz.tul.stin.paveltyl.service;

import cz.tul.stin.paveltyl.shipping.AirDelivery;
import cz.tul.stin.paveltyl.shipping.TruckDelivery;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;

// Testuji výběr správného způsobu dopravy pro pracovní den a víkend pomocí fixního času (Clock.fixed).
class OrderServiceTest {

    // Test ověřuje, že ve všední den se použije TruckDelivery.
    @Test
    void shouldUseTruckDeliveryOnWeekday() {

        // Vytvoření fixního času (pondělí).
        // Použití Clock.fixed zajistí deterministický test (nezávislý na aktuálním čase).
        Clock clock = Clock.fixed(
                Instant.parse("2026-03-09T10:00:00Z"), // pondělí
                ZoneId.of("UTC")
        );

        // OrderService dostává závislosti zvenku:
        // - clock (zdroj času)
        // - doprava pro pracovní dny (TruckDelivery)
        // - doprava pro víkend (AirDelivery)
        OrderService service = new OrderService(
                clock,
                new TruckDelivery(),
                new AirDelivery()
        );

        // Pro váhu 10 kg:
        // TruckDelivery → 100 + 10 * 10 = 200
        // Očekáváme tedy použití kamionové dopravy.
        assertEquals(200, service.createOrder(10));
    }

    // Test ověřuje, že o víkendu se použije AirDelivery.
    @Test
    void shouldUseAirDeliveryOnWeekend() {

        // Vytvoření fixního času (neděle).
        // Opět eliminujeme závislost na reálném čase.
        Clock clock = Clock.fixed(
                Instant.parse("2026-03-08T10:00:00Z"), // neděle
                ZoneId.of("UTC")
        );

        // Stejná konfigurace jako v předchozím testu,
        // ale díky jinému dni se vybere jiná doprava.
        OrderService service = new OrderService(
                clock,
                new TruckDelivery(),
                new AirDelivery()
        );

        // Pro váhu 10 kg:
        // AirDelivery → 300 + 25 * 10 = 550
        // Očekáváme tedy použití letecké dopravy.
        assertEquals(550, service.createOrder(10));
    }
}