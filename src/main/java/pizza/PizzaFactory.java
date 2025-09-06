package pizza;

public class PizzaFactory {
    public Pizza createPizza(String type){
        switch (type.toLowerCase()){
            case "veggie":
                return new VeggiePizza();
            case "margherita":
                return new MargheritaPizza();
            default:
                throw new IllegalArgumentException("Ukendt pizza type: " + type);
        }
    }
}
