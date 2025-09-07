package pizza;

public class HomeDelivery implements DeliveryStrategy {
    public void deliver(Pizza pizza) {
        System.out.println("Delivery method: Home Delivery selected. " +
                "Your pizza will arrive soon!\n");
    }

    @Override
    public String getName() {
        return "Home delivery";
    }
}
