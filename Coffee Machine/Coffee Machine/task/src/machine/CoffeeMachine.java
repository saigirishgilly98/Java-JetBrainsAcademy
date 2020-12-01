package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int water = 400, money = 550, milk = 540, coffeeBeans = 120, disposableCups = 9;
        while(true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            if (action.equals("exit")) {
                break;
            }
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String option = scanner.next();
                    if (option.equals("1")) {
                        if (water < 250) {
                            System.out.println("Sorry, not enough water!");
                            break;
                        } else if (coffeeBeans < 16) {
                            System.out.println("Sorry, not enough coffee beans!");
                            break;
                        }
                        water -= 250;
                        coffeeBeans -= 16;
                        money += 4;
                    } else if (option.equals("2")) {
                        if (water < 350) {
                            System.out.println("Sorry, not enough water!");
                            break;
                        } else if (coffeeBeans < 20) {
                            System.out.println("Sorry, not enough coffee beans!");
                            break;
                        } else if(milk < 75) {
                            System.out.println("Sorry, not enough milk!");
                            break;
                        }
                        water -= 350;
                        milk -= 75;
                        coffeeBeans -= 20;
                        money += 7;
                    } else if (option.equals("3")) {
                        if (water < 200) {
                            System.out.println("Sorry, not enough water!");
                            break;
                        } else if (coffeeBeans < 12) {
                            System.out.println("Sorry, not enough coffee beans!");
                            break;
                        } else if(milk < 100) {
                            System.out.println("Sorry, not enough milk!");
                            break;
                        }
                        water -= 200;
                        milk -= 100;
                        coffeeBeans -= 12;
                        money += 6;
                    } else if (option.equals("back")) {
                        break;
                    }
                    disposableCups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    water += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    milk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    coffeeBeans += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    disposableCups += scanner.nextInt();
                    break;
                case "take":
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;
                case "remaining":
                    printState(water, milk, coffeeBeans, disposableCups, money);
            }
        }
    }

    public static void printState(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println();
    }
}
