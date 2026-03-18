package cz.tul.stin.paveltyl.decorator;

import cz.tul.stin.paveltyl.shipping.ExpressDecorator;
import cz.tul.stin.paveltyl.shipping.InsuranceDecorator;
import cz.tul.stin.paveltyl.shipping.ShippingMethod;
import cz.tul.stin.paveltyl.shipping.TruckDelivery;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Testy ověřují chování dekorátorů nad ShippingMethod,
// včetně jejich kombinace a vlivu pořadí aplikace.
public class ShippingDecoratorTest {

    // Test ověřuje samostatné pojištění.
    // InsuranceDecorator přidává 5 % k aktuální ceně dopravy.
    @Test
    void shouldAddInsuranceFee() {

        // Základní cena TruckDelivery pro váhu 10 je 200.
        // Pojištění přidá 5 % → 200 + 10 = 210.
        ShippingMethod method =
                new InsuranceDecorator(new TruckDelivery());

        assertEquals(210, method.calculateCost(10));
    }

    // Test ověřuje samostatné expresní doručení.
    // ExpressDecorator zdvojnásobí cenu dopravy.
    @Test
    void shouldDoublePriceForExpressDelivery() {

        // Základní cena je 200.
        // Expres zdvojnásobí → 400.
        ShippingMethod method =
                new ExpressDecorator(new TruckDelivery());

        assertEquals(400, method.calculateCost(10));
    }

    // Test ověřuje kombinaci dekorátorů:
    // nejprve expresní doručení, poté pojištění.
    @Test
    void shouldApplyExpressThenInsurance() {

        // Pořadí:
        // 1) TruckDelivery → 200
        // 2) Express → 400
        // 3) Insurance → +5 % z 400 = 20 → 420
        ShippingMethod method =
                new InsuranceDecorator(
                        new ExpressDecorator(
                                new TruckDelivery()
                        )
                );

        assertEquals(420, method.calculateCost(10));
    }

    // Test ověřuje, že pořadí dekorátorů ovlivňuje výsledek.
    // Každý dekorátor pracuje s aktuální cenou,
    // proto změna pořadí vede k jinému výsledku.
    @Test
    void shouldProduceDifferentResultDependingOnOrder() {

        // Varianta 1:
        // 200 → Express → 400 → Insurance → 420
        ShippingMethod method1 =
                new InsuranceDecorator(
                        new ExpressDecorator(new TruckDelivery())
                );

        // Varianta 2:
        // 200 → Insurance → 210 → Express → 410
        ShippingMethod method2 =
                new ExpressDecorator(
                        new InsuranceDecorator(new TruckDelivery())
                );

        assertEquals(420, method1.calculateCost(10));
        assertEquals(410, method2.calculateCost(10));
    }
}