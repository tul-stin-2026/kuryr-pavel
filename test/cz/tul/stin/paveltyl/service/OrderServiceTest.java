package cz.tul.stin.paveltyl.service;

import cz.tul.stin.paveltyl.shipping.AirDelivery;
import cz.tul.stin.paveltyl.shipping.TruckDelivery;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;

// Testuji výběr správného způsobu dopravy pro pracovní den a víkend pomocí fixního času (Clock.fixed).
class OrderServiceTest {

    @Test
    void shouldUseTruckDeliveryOnWeekday() {
        Clock clock = Clock.fixed(
                Instant.parse("2026-03-09T10:00:00Z"), // pondělí
                ZoneId.of("UTC")
        );

        OrderService service = new OrderService(
                clock,
                new TruckDelivery(),
                new AirDelivery()
        );

        assertEquals(200, service.createOrder(10));
    }

    @Test
    void shouldUseAirDeliveryOnWeekend() {
        Clock clock = Clock.fixed(
                Instant.parse("2026-03-08T10:00:00Z"), // neděle
                ZoneId.of("UTC")
        );

        OrderService service = new OrderService(
                clock,
                new TruckDelivery(),
                new AirDelivery()
        );

        assertEquals(550, service.createOrder(10));
    }
}