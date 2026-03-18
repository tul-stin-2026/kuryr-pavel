package cz.tul.stin.paveltyl.service;

import cz.tul.stin.paveltyl.shipping.ShippingMethod;

import java.time.Clock;
import java.time.LocalDate;

// Třída OrderService slouží jako ukázka aplikační logiky
// a problémů testovatelnosti v reálných systémech.
// Na rozdíl od doménových tříd neřeší samotný výpočet,
// ale rozhodování, kdy a jak se jednotlivé komponenty použijí.
public class OrderService {

    private final Clock clock;
    private final ShippingMethod weekdayMethod;
    private final ShippingMethod weekendMethod;

    public OrderService(Clock clock,
                        ShippingMethod weekdayMethod,
                        ShippingMethod weekendMethod) {
        this.clock = clock;
        this.weekdayMethod = weekdayMethod;
        this.weekendMethod = weekendMethod;
    }

    public double createOrder(double weight) {
        LocalDate today = LocalDate.now(clock);

        ShippingMethod method =
                (today.getDayOfWeek().getValue() >= 6)
                        ? weekendMethod
                        : weekdayMethod;

        return method.calculateCost(weight);
    }
}

/*
Třída je špatně testovatelná kvůli závislosti na aktuálním čase,
vytváření objektů pomocí new uvnitř metody a použití System.out.
Použil jsem dependency injection (Clock a ShippingMethod), čímž
jsem odstranil závislosti na systému a umožnil deterministické testování.

1. Závislost na čase
test dnes projde, zítra ne
nedeterministické testy
2. new uvnitř metody
nemůžeš podstrčit fake / mock
netestovatelné
3. žádná kontrola zvenku
nemůžeš říct „teď je víkend“
4. System.out.println
bordel v testech

public class OrderService {

   public double createOrder(double weight) {
      ShippingMethod method;

      if (LocalDate.now().getDayOfWeek().getValue() >= 6) {
         method = new AirDelivery();
      } else {
         method = new TruckDelivery();
      }

      double price = method.calculateCost(weight);

      System.out.println("Order created, price = " + price);

      return price;
   }
}
*/