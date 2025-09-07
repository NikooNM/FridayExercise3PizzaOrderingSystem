package pizza;

public class Pickup implements DeliveryStrategy {
    public void deliver(Pizza pizza){
        System.out.println("Delivery method: Pickup selected. " +
                "Your pizza will arrive soon!\n");
    }

    @Override
    public String getName() {
        return "Pickup";
    }
}
