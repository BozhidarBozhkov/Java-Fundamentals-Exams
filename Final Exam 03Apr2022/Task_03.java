import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, Integer> stockInfo = new LinkedHashMap<>();
        Map<String, Integer> sales = new TreeMap<>();
        int count = 0;

        while (!line.equals("Complete")) {
            String[] data = line.split(" ");
            String command = data[0];

            switch (command) {
                case "Receive":
                    int qty = Integer.parseInt(data[1]);
                    String food = data[2];
                    if (stockInfo.containsKey(food) && qty > 0) {
                        int newQuantity = stockInfo.get(food) + qty;
                        stockInfo.put(food, newQuantity);
                    } else if (qty > 0) {
                        stockInfo.put(food, qty);
                    } else {
                        line = scanner.nextLine();
                        continue;
                    }
                    break;

                case "Sell":
                    int qty2 = Integer.parseInt(data[1]);
                    String food2 = data[2];

                    if (stockInfo.containsKey(food2)) {

                        if (qty2 <= stockInfo.get(food2)) {
                            sales.put(food2, qty2);
                            stockInfo.put(food2, stockInfo.get(food2) - qty2);

                            if (stockInfo.get(food2) == 0) {
                                stockInfo.remove(food2);
                            }
                            System.out.printf("You sold %d %s.\n", qty2, food2);
                            break;
                        } else {
                            sales.put(food2, stockInfo.get(food2));
                            stockInfo.remove(food2);
                            System.out.printf("There aren't enough %s. You sold the last %d of them.\n", qty2, stockInfo.get(food2));
                        }

                    } else {
                        System.out.printf("You do not have any %s.\n", food2);
                    }

                    break;
            }
            line = scanner.nextLine();

        }
        for (Map.Entry<String, Integer> entry : stockInfo.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : sales.entrySet()) {
            int allSales = stringIntegerEntry.getValue();
            count += allSales;

        }
        System.out.printf("All sold: %d goods\n", count);
    }
}

