package cz.tul.stin.paveltyl.delivery;

import cz.tul.stin.paveltyl.discount.NoDiscount;
import cz.tul.stin.paveltyl.discount.PercentageDiscount;
import cz.tul.stin.paveltyl.shipping.TruckDelivery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// black-box (integrační) // kombinace dopravy a slevy
// Ověřujeme spolupráci více tříd (Delivery + ShippingMethod + DiscountStrategy).
class DeliveryWithDiscountTest {

    @Test
    void shouldApplyPercentageDiscount() {
        Delivery d = new Delivery(
                "CZ005",
                10,
                new TruckDelivery(),
                new PercentageDiscount(10)
        );

        assertEquals(180, d.calculatePrice());
    }

    @Test
    void shouldNotChangePriceWithNoDiscount() {
        Delivery d = new Delivery(
                "CZ006",
                10,
                new TruckDelivery(),
                new NoDiscount()
        );

        assertEquals(200, d.calculatePrice());
    }
}
