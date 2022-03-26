import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());

        String[] line = scanner.nextLine().split(":");

        while (!line[0].equals("Travel")) {
            String command = line[0];
            String destination = line[2];
            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(String.valueOf(line[1]));
                    if (index < stops.length()) {
                        stops.insert(index, destination);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(String.valueOf(line[1]));
                    int endIndex = Integer.parseInt(String.valueOf(line[2]));
                    if (startIndex < stops.length() && endIndex < stops.length()){
                        stops.delete(startIndex, endIndex + 1);
                    }
                    break;
                case "Switch":
                    String oldString = line[1];
                    String newString = line[2];
                    index = stops.indexOf(oldString);
                    if (index != -1){
                        stops.replace(index, index + oldString.length(), newString);
                    }
                    break;
            }
            System.out.println(stops);
            line = scanner.nextLine().split(":");
        }
        System.out.printf("Ready for world tour! Planned stops: %s", stops);
    }

}
