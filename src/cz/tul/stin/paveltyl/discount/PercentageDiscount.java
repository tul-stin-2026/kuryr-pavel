package cz.tul.stin.paveltyl.discount;

// Procentuální sleva
public class PercentageDiscount implements DiscountStrategy {

    private final double percentage;                         // Hodnota slevy

    public PercentageDiscount(double percentage) {     // Konstruktor
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Discount must be 0–100");
        }
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {        // Aplikace slevy
        return price - (price * percentage / 100);     // Výpočet
    }
}