import java.util.Scanner;

public class FitnessCard_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String sex = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String sport = scanner.nextLine();

        double price = 0;

        if (sex.equals("m")){
            if (age <= 19){
                switch (sport){
                    case "Gym":
                        price = 42 * 0.8;
                        break;
                    case "Boxing":
                        price =  41 * 0.8;
                        break;
                    case "Yoga":
                        price = 45 * 0.8;
                        break;
                    case "Zumba":
                        price = 34 * 0.8;
                        break;
                    case "Dances":
                        price = 51 * 0.8;
                        break;
                    case "Pilates":
                        price = 39 * 0.8;
                        break;
                }
            } else {
                switch (sport){
                    case "Gym":
                        price = 42;
                        break;
                    case "Boxing":
                        price =  41;
                        break;
                    case "Yoga":
                        price = 45;
                        break;
                    case "Zumba":
                        price = 34;
                        break;
                    case "Dances":
                        price = 51;
                        break;
                    case "Pilates":
                        price = 39;
                        break;
                }
            }
        } else if (sex.equals("f")){
            if (age <= 19){
                switch (sport){
                    case "Gym":
                        price = 35 * 0.8;
                        break;
                    case "Boxing":
                    case "Pilates":
                        price =  37 * 0.8;
                        break;
                    case "Yoga":
                        price = 42 * 0.8;
                        break;
                    case "Zumba":
                        price = 31 * 0.8;
                        break;
                    case "Dances":
                        price = 53 * 0.8;
                        break;
                }
            } else {
                switch (sport){
                    case "Gym":
                        price = 35 * 0.8;
                        break;
                    case "Boxing":
                    case "Pilates":
                        price =  37 * 0.8;
                        break;
                    case "Yoga":
                        price = 42 * 0.8;
                        break;
                    case "Zumba":
                        price = 31 * 0.8;
                        break;
                    case "Dances":
                        price = 53 * 0.8;
                        break;
                }
            }
        }
        if (budget >= price){
            System.out.printf("You purchased a 1 month pass for %s.", sport);
        } else {
            System.out.printf("You don't have enough money! You need $%.2f more.", Math.abs(price - budget));
        }
    }
}
