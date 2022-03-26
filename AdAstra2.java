import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra2 {
    static class Item {
        String itemName;
        String expirationDate;
        int calories;

        public Item(String itemName, String expirationDate, int calories) {
            this.itemName = itemName;
            this.expirationDate = expirationDate;
            this.calories = calories;
        }

        public String getItemName() {
            return itemName;
        }

        public String getExpirationDate() {
            return expirationDate;
        }

        public int getCalories() {
            return calories;
        }

        @Override
        public String toString() {
            return String.format("Item: %s, Best before: %s, Nutrition: %d", this.itemName, this.expirationDate, this.calories);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([#\\|])(?<itemName>[A-Za-z ]+)\\1(?<expirationDate>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1";

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<Item> itemList = new ArrayList<>();
        while (matcher.find()) {
            String itemName = matcher.group("itemName");
            String expirationDate = matcher.group("expirationDate");
            int calories = Integer.parseInt(matcher.group("calories"));

            Item item = new Item(itemName, expirationDate, calories);
            itemList.add(item);

        }
        int days = itemList.stream().mapToInt(Item::getCalories).sum() / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);
        itemList.forEach(System.out::println);

    }

}
