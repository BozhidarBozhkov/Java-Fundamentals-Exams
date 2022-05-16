import java.util.Scanner;

public class SuitcasesLoad_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double capacity = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();

        int countSuitcases = 0;
        while (!command.equals("End")){

            double volume = Double.parseDouble(command);

            if (capacity <= volume){
                System.out.println("No more space!");
                break;
            }
            countSuitcases ++;
            if (countSuitcases % 3 == 0){
                volume = volume * 1.1;
            }
            capacity -= volume;

            command = scanner.nextLine();
            volume = 0;
        }
        if (command.equals("End")){
            System.out.println("Congratulations! All suitcases are loaded!");
        }
        System.out.printf("Statistic: %d suitcases loaded.", countSuitcases);
    }
}
