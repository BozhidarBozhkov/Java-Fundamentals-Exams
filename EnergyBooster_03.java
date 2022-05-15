import java.util.Scanner;

public class EnergyBooster_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String setSize = scanner.nextLine();
        int numberOfSets = Integer.parseInt(scanner.nextLine());

        double finalPrice = 0;

        if (setSize.equals("small")){
            switch (fruit){
                case "Watermelon":
                    finalPrice = numberOfSets * 56 * 2;
                    break;
                case "Mango":
                    finalPrice = numberOfSets * 36.66 * 2;
                    break;
                case "Pineapple":
                    finalPrice = numberOfSets * 42.10 * 2;
                    break;
                case "Raspberry":
                    finalPrice = numberOfSets * 20 * 2;
                    break;
            }
        } else if (setSize.equals("big")){
            switch (fruit){
                case "Watermelon":
                    finalPrice = numberOfSets * 28.70 * 5;
                    break;
                case "Mango":
                    finalPrice = numberOfSets * 19.60 * 5;
                    break;
                case "Pineapple":
                    finalPrice = numberOfSets * 24.80 * 5;
                    break;
                case "Raspberry":
                    finalPrice = numberOfSets * 15.20 * 5;
                    break;
            }
        }
        if (finalPrice >= 400 && finalPrice <= 1000){
            finalPrice = finalPrice * 0.85;
        } else if (finalPrice > 1000){
            finalPrice = finalPrice * 0.5;
        }
        System.out.printf("%.2f lv.", finalPrice);
    }
}
