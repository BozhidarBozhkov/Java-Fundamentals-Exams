import java.util.Scanner;

public class ChangeBureau_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bitcoins = Integer.parseInt(scanner.nextLine());
        double yuan = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        double bitcoinInLeva = 1168.00 / 1.95;
        double yuanInLeva = 0.15 * 1.76 / 1.95;
        double dollarInLeva = 1.76 / 1.95;

        double result = bitcoins * bitcoinInLeva + yuan * yuanInLeva;

        double finalAmount = result - result * commission / 100;

        System.out.printf("%.2f", finalAmount);
    }
}
