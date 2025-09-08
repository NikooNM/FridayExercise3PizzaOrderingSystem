package pizza;

public class OlivesTopping extends ToppingDecorator {
    //Constructor with actual pizza, and name and price of topping
    public OlivesTopping(Pizza pizza) {
        super(pizza, "Olives", 3.0);
    }

    @Override
    public String getDescription(){
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost(){
        return pizza.getCost() + 3;
    }
}
