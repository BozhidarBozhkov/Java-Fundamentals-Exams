import java.util.Scanner;

public class AgencyProfit_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String airlineName = scanner.nextLine();
        int adultTickets = Integer.parseInt(scanner.nextLine());
        int kidTickets = Integer.parseInt(scanner.nextLine());
        double netTicketPrice = Double.parseDouble(scanner.nextLine());
        double adminFee = Double.parseDouble(scanner.nextLine());

        double kidTicketPrice = netTicketPrice - 0.7 * netTicketPrice + adminFee;
        double agencyProfit = (adultTickets * (netTicketPrice + adminFee) + (kidTicketPrice * kidTickets)) * 0.2;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", airlineName, agencyProfit);
    }
}
