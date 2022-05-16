import java.util.Scanner;

public class MountainRun_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordInSeconds = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeInSecondsPerMeter = Double.parseDouble(scanner.nextLine());

        double timeInSeconds = distance * timeInSecondsPerMeter;

        double timesDelayed = Math.floor(distance / 50);
        double addSeconds = timesDelayed * 30;
        double totalTime = addSeconds + timeInSeconds;

        if (totalTime < recordInSeconds){
            System.out.printf("Yes! The new record is %.2f seconds.",totalTime);
        } else  {
            System.out.printf("No! He was %.2f seconds slower.", Math.abs(recordInSeconds - totalTime));
        }
    }
}
