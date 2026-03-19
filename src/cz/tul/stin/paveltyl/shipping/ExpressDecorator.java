package cz.tul.stin.paveltyl.shipping;

// Expresní příplatek
public class ExpressDecorator extends ShippingDecorator {

    private static final double EXPRESS_FEE = 200;     // Expresní příplatek

    public ExpressDecorator(ShippingMethod wrapped) {
        super(wrapped);                                // Předání původní dopravy
    }

    @Override
    public double calculateCost(double weight) {       // Přepsání výpočtu
        return wrapped.calculateCost(weight)           // Původní cena
                + EXPRESS_FEE;                         // + expres příplatek
    }
}
