import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^@#+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+$");
        List<String> products = new ArrayList<>();
        StringBuilder productGroup = new StringBuilder();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);

            if (!matcher.find()){
                System.out.println("Invalid barcode");
            } else {
                products.add(matcher.group("product"));
                for (String item : products) {
                    productGroup.setLength(0);
                    for (int j = 0; j < item.length(); j++) {
                        if (item.charAt(j) >= 48 && item.charAt(j) <= 57){
                            char digit = item.charAt(j);
                            productGroup.append(digit);
                        }
                    }
                }
                if (productGroup.length() == 0){
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + productGroup);
                }
            }
        }
    }
}
