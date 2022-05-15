import java.util.Scanner;

public class CareOfPuppy_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int foodInKg = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int totalFoodInGrams = foodInKg * 1000;
        int leftovers = 0;
        while (!command.equals("Adopted")){
            int foodInGrams = Integer.parseInt(command);
            leftovers += foodInGrams;

            command = scanner.nextLine();
        }
        if (totalFoodInGrams >= leftovers){
            System.out.printf("Food is enough! Leftovers: %d grams.", totalFoodInGrams - leftovers);
        } else  {
            System.out.printf("Food is not enough. You need %d grams more.", Math.abs(leftovers - totalFoodInGrams));
        }
    }
}
