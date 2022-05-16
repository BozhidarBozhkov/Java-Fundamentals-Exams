import java.util.Scanner;

public class TournamentOfChristmas_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());

        double totalMoneyWon = 0;
        int totalWins = 0;
        int totalLose = 0;
        for (int i = 1; i <= days ; i++) {
            String command = scanner.nextLine();
            int countWins = 0;
            int countLose = 0;
            double moneyWon = 0;
            while (!command.equals("Finish")) {
                String sport = command;
                String result = scanner.nextLine();

                switch (result){
                    case "win":
                        countWins++;
                        totalWins++;
                        moneyWon += 20;
                        break;
                    case "lose":
                        countLose++;
                        totalLose++;
                        break;
                }
                command = scanner.nextLine();

            }
            if (countWins > countLose){
                moneyWon = moneyWon * 1.1;
            }
            totalMoneyWon += moneyWon;
        }
        if (totalWins > totalLose){
            totalMoneyWon = totalMoneyWon * 1.2;
            System.out.printf("You won the tournament! Total raised money: %.2f", totalMoneyWon);
        } else  {
            System.out.printf("You lost the tournament! Total raised money: %.2f", totalMoneyWon);
        }
    }
}
