import java.awt.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([@#]+)(?<color>[a-z]{3,})(\\W+)*\\/+(\\d+)\\/+";
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            String color = matcher.group("color");
            int count = Integer.parseInt(matcher.group(4));
            System.out.printf("You found %d %s eggs!\n", count, color);
        }
    }

}
