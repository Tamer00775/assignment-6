public abstract class PizzaDecorator extends Pizza {

    protected Pizza pizza;
    public PizzaDecorator(Pizza pizza) {
        super(pizza.getPrice());
        this.pizza = pizza;
    }

    @Override
    public Double getPrice() {
        return pizza.getPrice();
    }
}

class PepperoniTopping extends PizzaDecorator {
    public PepperoniTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 2;
    }
}

// Декоратор MushroomTopping
class MushroomTopping extends PizzaDecorator {
    public MushroomTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 1.5;
    }
}