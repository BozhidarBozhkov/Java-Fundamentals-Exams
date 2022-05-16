import java.util.Scanner;

public class FoodForPets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double totalFood = Double.parseDouble(scanner.nextLine());
        double biscuits = 0;
        int foodPerDay = 0;
        double totalFoodPerDay = 0;
        int dogAllFood = 0;
        int catAllFood = 0;
        for (int i = 1; i <= days ; i++) {
            int dogFood = Integer.parseInt(scanner.nextLine());
            int catFood = Integer.parseInt(scanner.nextLine());
            dogAllFood += dogFood;
            catAllFood += catFood;
            foodPerDay = dogFood + catFood;
            if (i % 3 == 0){
               biscuits = Math.round(foodPerDay * 0.1);
            }
            totalFoodPerDay += foodPerDay;
        }
        System.out.printf("Total eaten biscuits: %.0fgr.%n", biscuits);
        System.out.printf("%.2f%% of the food has been eaten.%n", totalFoodPerDay / totalFood * 100);
        System.out.printf("%.2f%% eaten from the dog.%n", dogAllFood / totalFoodPerDay * 100);
        System.out.printf("%.2f%% eaten from the cat.%n", catAllFood / totalFoodPerDay * 100);
    }
}
