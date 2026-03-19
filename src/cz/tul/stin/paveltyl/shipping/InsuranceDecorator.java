package cz.tul.stin.paveltyl.shipping;

// Připojištění zásilky
public class InsuranceDecorator extends ShippingDecorator {

    private static final double INSURANCE_PERCENT = 5; // 5 % z ceny

    public InsuranceDecorator(ShippingMethod wrapped) {
        super(wrapped);
    }

    @Override
    public double calculateCost(double weight) {

        double basePrice = wrapped.calculateCost(weight);  // Původní cena

        return basePrice + (basePrice * INSURANCE_PERCENT / 100); // + pojištění
    }
}