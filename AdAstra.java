import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([#\\|])(?<itemName>[A-Za-z ]+)\\1(?<expirationDate>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1";

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> items = new ArrayList<>();
        Map<String, String> itemsDate = new LinkedHashMap<>();
        Map<String, Integer> itemsCalories = new LinkedHashMap<>();
        int totalCalories = 0;
        while (matcher.find()) {
            String itemName = matcher.group("itemName");
            String expirationDate = matcher.group("expirationDate");
            int calories = Integer.parseInt(matcher.group("calories"));

            itemsDate.put(itemName, expirationDate);
            itemsCalories.put(itemName, calories);
            totalCalories += calories;
            items.add(String.format("Item: %s, Best before: %s, Nutrition: %d%n", itemName, expirationDate, calories));
        }
        int daysWithFood = totalCalories / 2000;
        System.out.println("You have food to last you for: " + daysWithFood + " days!");

        items.forEach(System.out::print);

    }

}
