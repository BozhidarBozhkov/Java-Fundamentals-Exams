import java.util.Scanner;

public class BirthdayParty_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rent = Double.parseDouble(scanner.nextLine());

        double cakePrice = rent * 0.2;
        double drinksPrice = cakePrice - cakePrice * 0.45;
        double animator = rent / 3;

        double budget = rent + cakePrice + drinksPrice + animator;

        System.out.println(budget);
    }
}
