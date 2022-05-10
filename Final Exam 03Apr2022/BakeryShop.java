import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BakeryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Integer> stockInfo = new LinkedHashMap<>();
        Map<String, Integer> stockSell = new LinkedHashMap<>();
        int counter = 0;

        while (!line.equals("Complete")){
            String[] data = line.split("\\s+");
            String command = data[0];

            switch (command){
                case "Receive":
                    int qty = Integer.parseInt(data[1]);
                    String food = data[2];
                    if (qty <= 0){
                        line = scanner.nextLine();
                        continue;
                    } else if (stockInfo.containsKey(food)){
                        int newQty = stockInfo.get(food) + qty;
                        stockInfo.put(food, newQty);
                    } else {
                        stockInfo.put(food, qty);
                    }
                    break;
                case "Sell":
                    qty = Integer.parseInt(data[1]);
                    food = data[2];
//                        if (!stockInfo.containsKey(food)){
//                            System.out.println("You do not have any " + food);
                         if (stockInfo.containsKey(food)){

                            if (qty <= stockInfo.get(qty)){
                            stockSell.put(food, qty);
                            stockInfo.put(food, stockInfo.get(food) - qty);
                            if (stockInfo.get(food) == 0){
                                stockInfo.remove(food);
                            }
                            System.out.printf("You sold %d %s\n", qty, food);
                        } else {
                            stockSell.put(food, stockInfo.get(food));
                            stockInfo.remove(food);
                                System.out.printf("There aren't enough %s. You sold the last %d of them.\n", food, stockInfo.get(food));
                            }
                        } else  {
                             System.out.println("You do not have any " + food);
                         }
                    break;
            }

            line = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry: stockInfo.entrySet()){
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry: stockSell.entrySet()){
            int soldProducts = entry.getValue();
            counter += soldProducts;
        }
        System.out.printf("All sold: %d goods", counter);
    }

}
