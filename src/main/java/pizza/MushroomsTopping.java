package pizza;

public class MushroomsTopping extends ToppingDecorator {
    //Constructor with actual pizza, and name and price of topping
    public MushroomsTopping(Pizza pizza) {
        super(pizza, "Mushrooms", 2.0);
    }

    @Override
    public String getDescription(){
        return pizza.getDescription() + ", Mushrooms";
    }

    @Override
    public double getCost(){
        return pizza.getCost() + 2;
    }
}
