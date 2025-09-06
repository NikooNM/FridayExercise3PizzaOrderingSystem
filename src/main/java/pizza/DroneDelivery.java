package pizza;

public class DroneDelivery implements DeliveryStrategy {
    public void deliver(Pizza pizza){
        System.out.println("Delivery method: Drone Delivery selected. " +
                "Your pizza will arrive soon!\n");
    }
}
