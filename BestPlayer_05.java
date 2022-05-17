import java.util.Scanner;

public class BestPlayer_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command  = scanner.nextLine();
        String bestPlayer = "";
        int maxGoals = Integer.MIN_VALUE;
        while (!command.equals("END")){
            String playerName = command;
            int goals = Integer.parseInt(scanner.nextLine());
            if  (goals > maxGoals){
                maxGoals = goals;
                bestPlayer = playerName;
            }
            if (goals >= 10){
                //System.out.printf("%s is the best player!%n", playerName);
                //System.out.printf("He has scored %d goals and made a hat-trick!!!%n", goals);
                break;
            }

            command = scanner.nextLine();
        }
        System.out.printf("%s is the best player!%n", bestPlayer);
        if (maxGoals >= 3){
            System.out.printf("He has scored %d goals and made a hat-trick !!!%n", maxGoals);
        } else {
            System.out.printf("He has scored %d goals.%n", maxGoals);
        }
    }
}
