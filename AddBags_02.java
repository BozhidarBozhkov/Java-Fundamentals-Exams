import java.util.Scanner;

public class AddBags_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double bagsOver20Price = Double.parseDouble(scanner.nextLine());
        double bagsKilograms = Double.parseDouble(scanner.nextLine());
        int daysUntilTrip = Integer.parseInt(scanner.nextLine());
        int numberOfBags = Integer.parseInt(scanner.nextLine());

        double bagsTotalPrice = 0;

        double bagsPrice10To20 = bagsOver20Price * 0.5;
        double bagsPriceUpTo10 = bagsOver20Price * 0.2;

        if (daysUntilTrip > 30){
            if (bagsKilograms <= 10){
                bagsTotalPrice = bagsPriceUpTo10 * 1.1;
            } else if (bagsKilograms > 10 && bagsKilograms <= 20) {
                bagsTotalPrice = bagsPrice10To20 * 1.10;
            } else if (bagsKilograms > 20){
                bagsTotalPrice = bagsOver20Price * 1.1;
            }
        } else if (daysUntilTrip >= 7 && daysUntilTrip <= 30) {
            if (bagsKilograms <= 10){
                bagsTotalPrice = bagsPriceUpTo10 * 1.15;
            } else if (bagsKilograms > 10 && bagsKilograms <= 20) {
                bagsTotalPrice = bagsPrice10To20 * 1.15;
            } else if (bagsKilograms > 20){
                bagsTotalPrice = bagsOver20Price * 1.15;
            }

        } else if (daysUntilTrip < 7){
            if (bagsKilograms <= 10){
                bagsTotalPrice = bagsPriceUpTo10 * 1.4;
            } else if (bagsKilograms > 10 && bagsKilograms <= 20) {
                bagsTotalPrice = bagsPrice10To20 * 1.4;
            } else if (bagsKilograms > 20){
                bagsTotalPrice = bagsOver20Price * 1.4;
            }
        }
        bagsTotalPrice = bagsTotalPrice * numberOfBags;
        System.out.printf("The total price of bags is: %.2f lv. ", bagsTotalPrice);
    }
}
