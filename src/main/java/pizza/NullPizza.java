package pizza;

public class NullPizza implements Pizza {
    @Override public String getDescription() { return "";}
    @Override public double getCost() { return 0.0;}
}
