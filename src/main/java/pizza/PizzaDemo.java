package pizza;

public class PizzaDemo {
    public static void main(String[] args) {
        PizzaFactory factory = new PizzaFactory();

        //Factory pattern: Makes many pizzas, a setup for all of them to avoid repetition
        Pizza margherita = factory.createPizza("Margherita");
        Pizza veggie = factory.createPizza("VeGGIe");

        System.out.println(margherita.getDescription() + " " + margherita.getCost() + "\n"
                + veggie.getDescription() + " " + veggie.getCost() + "\n");

        //Decorator pattern: Adds topping to pizza without making lots of subclasses, also easier to maintain
        margherita = new PepperoniTopping(margherita);
        veggie = new CheeseTopping(veggie);
        veggie = new PepperoniTopping(veggie);

        System.out.println(margherita.getDescription() + " " + margherita.getCost() + "\n"
                + veggie.getDescription() + " " + veggie.getCost() + "\n");

        //Strategy pattern:
        Order o1 = new Order(margherita);
        o1.setDeliveryStrategy(new Pickup());

        Order o2 = new Order(veggie);
        o2.setDeliveryStrategy(new DroneDelivery());

        o1.processOrder();
        o2.processOrder();
    }
}
