public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza(10.0);
        System.out.println("Base Pizza Price: $" + pizza.getPrice());

        pizza = new PepperoniTopping(pizza);
        pizza = new MushroomTopping(pizza);

        System.out.println("Final Pizza Price: $" + pizza.getPrice());
    }
}