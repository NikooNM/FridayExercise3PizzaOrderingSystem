package pizza;

public class CheeseTopping extends ToppingDecorator {
    //Constructor with actual pizza, and name and price of topping
    public CheeseTopping(Pizza pizza) {
        super(pizza, "Cheese", 5.0);
    }

    @Override
    public String getDescription(){
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost(){
        return pizza.getCost() + 5;
    }
}
