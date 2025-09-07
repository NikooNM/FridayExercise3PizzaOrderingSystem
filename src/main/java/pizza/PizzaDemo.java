package pizza;

import java.util.ArrayList;
import java.util.Scanner;

public class PizzaDemo {
    public static void main(String[] args) {
        //#1:
        //Minimal requirements
        PizzaFactory factory = new PizzaFactory();

        //Factory pattern: Makes many pizzas, a setup for all of them to avoid repetition
        Pizza margherita = factory.createPizza("Margherita");
        Pizza veggie = factory.createPizza("VeGGIe");

        System.out.println(margherita.getDescription() + " " + margherita.getCost() + "\n"
                + veggie.getDescription() + " " + veggie.getCost() + "\n");

        //Decorator pattern: Adds topping to pizza without making lots of subclasses, also easier to maintain
        margherita = new PepperoniTopping(margherita);
        veggie = new CheeseTopping(veggie);
        veggie = new PepperoniTopping(veggie);

        System.out.println(margherita.getDescription() + " " + margherita.getCost() + "\n"
                + veggie.getDescription() + " " + veggie.getCost() + "\n");

        //Strategy pattern: Makes one order (one class/interface)
        //and puts 3 delivery methods in their own single classes (that uses order class methods)
        Order o1 = new Order(margherita);
        o1.setDeliveryStrategy(new Pickup());

        Order o2 = new Order(veggie);
        o2.setDeliveryStrategy(new DroneDelivery());

        o1.processOrder();
        o2.processOrder();

        System.out.println("***End of first part of code***\n");
        //#2:
        //Integration & extensions - Build a console flow

        //Adds pizzas to a printable menu
        PizzaMenu p = new PizzaMenu();
        p.addPizza(new MargheritaPizza());
        p.addPizza(new VeggiePizza());

        //Adds toppings to a dummy pizza to print them later on in the console flow
        Pizza dummy = new NullPizza();
        ToppingOptions t = new ToppingOptions();
        t.addTopping(new CheeseTopping(dummy));
        t.addTopping(new PepperoniTopping(dummy));

        //Adds delivery methods to a list
        ArrayList<DeliveryStrategy> deliveryOptions = new ArrayList<>();
        deliveryOptions.add(new DroneDelivery());
        deliveryOptions.add(new HomeDelivery());
        deliveryOptions.add(new Pickup());

        //Making a new instance of Scanner, creating a scanner
        Scanner sc = new Scanner(System.in);

        //Start of program output
        //i.
        System.out.println("Hello customer, welcome to my pizza restaurant.\n" +
                "Please tell me what type of pizza you would like to order :-)\n");

        p.displayMenuOnlyPizzas();

        System.out.println("\nChoose a pizza (1-" + p.getMenuOfPizzas().size() + "):");
        int choicePizza = sc.nextInt() - 1;

        Pizza chosenPizza = p.getPizzaFromMenu(choicePizza);
        System.out.println("\nYou chose " + chosenPizza.getDescription() + " $" + chosenPizza.getCost());

        //ii.
        System.out.println("\nDo you wish to add topping to your " + chosenPizza.getDescription() +
                ". Here are your options:");
        while (true) {
            if (t.size() == 0){
                break;
            }
            t.displayToppings();
            System.out.println("\nChoose a topping (enter 0 to finish)");

            if (!sc.hasNextInt()) {
                sc.next();
                System.out.println("\n*Please use numbers. Try again.*\n");
                continue;
            }

            int choiceTopping = sc.nextInt();

            if ((((choiceTopping - 1) < 0 && choiceTopping != 0) || (choiceTopping - 1) >= t.size())) {
                System.out.println("\nInvalid choice. Try again.");
                continue;
            }

            Pizza chosenTopping;
            if (choiceTopping != 0){
                chosenTopping = t.get(choiceTopping - 1);
            } else {
                break;
            }

            if (chosenTopping instanceof CheeseTopping){
                chosenPizza = new CheeseTopping(chosenPizza);
            } else if (chosenTopping instanceof PepperoniTopping){
                chosenPizza = new PepperoniTopping(chosenPizza);
            } else {
                System.out.println("Unknown topping type. Try again.");
                continue;
            }

            t.remove(choiceTopping-1);
            System.out.println("\nNew unfinished order: " + chosenPizza.getDescription() + " $" + chosenPizza.getCost());

            if (!(t.size() == 0)) {
                System.out.println("\nDo you want more toppings? " +
                        "Here are your remaining options:");
            }
        }

        //iii.
        System.out.println("\nChoose a delivery method:\n");

        for (int i = 0; i < deliveryOptions.size(); i++) {
            System.out.println(i+1 + ". " + deliveryOptions.get(i).getName());
        }

        int choiceDelivery = sc.nextInt();

        DeliveryStrategy chosenDeliveryMethod = deliveryOptions.get(choiceDelivery-1);
        System.out.println();
        chosenDeliveryMethod.deliver(chosenPizza);

        //iv.
        System.out.println("**Final receipt: You have ordered " + chosenPizza.getDescription() + " $" + chosenPizza.getCost() + " and chosen " + chosenDeliveryMethod.getName() + ".**" +
                "\n \n--- Thank you for ordering food at our pizza restaurant. We hope to see you again next time! :-) ---");
    }
}