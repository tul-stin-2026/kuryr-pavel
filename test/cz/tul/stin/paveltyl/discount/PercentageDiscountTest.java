package cz.tul.stin.paveltyl.discount;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// black-box // matematický výpočet slevy
// Ověřujeme správný výpočet procent (např. 10 %, 0 %, 100 %).
class PercentageDiscountTest {

    @Test
    void shouldApply10PercentDiscount() {
        PercentageDiscount discount = new PercentageDiscount(10);

        assertEquals(90, discount.applyDiscount(100));
    }

    @Test
    void shouldApplyZeroPercentDiscount() {
        PercentageDiscount discount = new PercentageDiscount(0);

        assertEquals(100, discount.applyDiscount(100));
    }

    @Test
    void shouldApplyFullDiscount() {
        PercentageDiscount discount = new PercentageDiscount(100);

        assertEquals(0, discount.applyDiscount(100));
    }

    @Test
    void shouldWorkWithDecimalValues() {
        PercentageDiscount discount = new PercentageDiscount(10);

        assertEquals(89.991, discount.applyDiscount(99.99), 0.001);
    }

    @Test
    void shouldThrowExceptionForInvalidPercentage() {
        assertThrows(IllegalArgumentException.class,
                () -> new PercentageDiscount(-10));

        assertThrows(IllegalArgumentException.class,
                () -> new PercentageDiscount(150));
    }
}