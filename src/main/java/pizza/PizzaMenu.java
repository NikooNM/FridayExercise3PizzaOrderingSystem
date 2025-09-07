package pizza;

import java.util.ArrayList;

public class PizzaMenu {
    private final ArrayList<Pizza> menuOfPizzas = new ArrayList<>();

    public void addPizza(Pizza pizza){
        (this.menuOfPizzas).add(pizza);
    }

    public void displayMenuOnlyPizzas(){
        for (int i = 0; i < (this.menuOfPizzas).size(); i++){
            Pizza p = menuOfPizzas.get(i);
            System.out.println(i+1 + ". " + p.getDescription() + " $" + p.getCost());
        }
    }

    public ArrayList<Pizza> getMenuOfPizzas(){
        return this.menuOfPizzas;
    }

    public Pizza getPizzaFromMenu(int index){
        return (this.menuOfPizzas).get(index);
    }
}
