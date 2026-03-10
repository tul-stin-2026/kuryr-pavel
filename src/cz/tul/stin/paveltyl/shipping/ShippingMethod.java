package cz.tul.stin.paveltyl.shipping;

// Rozhraní definující způsob dopravy
public interface ShippingMethod { // Společný typ pro všechny druhy dopravy

    double calculateCost(double weight);              // Každá doprava musí umět spočítat cenu podle váhy
}
