package pizza;

public class PepperoniTopping extends ToppingDecorator {
    //Constructor with actual pizza, and name and price of topping
    public PepperoniTopping(Pizza pizza) {
        super(pizza, "Pepperoni", 10.0);
    }

    @Override
    public String getDescription(){
        return pizza.getDescription() + ", Pepperoni";
    }

    @Override
    public double getCost(){
        return pizza.getCost() + 10;
    }
}
