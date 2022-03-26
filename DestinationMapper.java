import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile("([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(line);

        List<String> destinationsList = new ArrayList<>();
        int points = 0;
        while (matcher.find()) {
            String destination = matcher.group("destination");
            destinationsList.add(destination);
            points += destination.length();

        }
        System.out.println("Destinations: " + String.join(", ", destinationsList));
        System.out.printf("Travel Points: %d", points);
    }
}
