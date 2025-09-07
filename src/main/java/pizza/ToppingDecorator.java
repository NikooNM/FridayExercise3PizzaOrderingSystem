package pizza;

public abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;
    protected String name;
    protected double price;

    public ToppingDecorator(Pizza pizza, String name, double price) {
        this.pizza = pizza;
        this.name = name;
        this.price = price;
    }
}
