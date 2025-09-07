package pizza;

import java.util.ArrayList;

public class ToppingOptions {
    private final ArrayList<Pizza> toppings = new ArrayList<>();

    //Adds dummy pizza to toppingOptions instance
    //and the dummy pizza contains all the toppings
    public void addTopping(Pizza topping){
        toppings.add(topping);
    }

    public void displayToppings(){
        for (int i = 0; i < toppings.size(); i++){
            System.out.println(i+1 + ". " + toppings.get(i).getDescription().replaceAll(", ", "") + " $" + toppings.get(i).getCost());
        }
    }

    public Pizza get(int index){
        return toppings.get(index);
    }

    public int size(){
        return toppings.size();
    }

    public void remove (int index) {
        toppings.remove(index);
    }
}
