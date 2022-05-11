import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^([$%])(?<tag>[A-Z][a-z]{3,})\\1:\\s\\[(?<group1>\\d+)\\]\\|\\[(?<group2>\\d+)\\]\\|\\[(?<group3>\\d+)\\]\\|$";
        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();
            Matcher matcher = pattern.matcher(message);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                char firstSymbol = (char) Integer.parseInt(matcher.group("group1"));
                char secondSymbol = (char) Integer.parseInt(matcher.group("group2"));
                char thirdSymbol = (char) Integer.parseInt(matcher.group("group3"));

                System.out.printf("%s: " + firstSymbol + secondSymbol + thirdSymbol, tag);
                System.out.println();

            } else {
                System.out.println("Valid message not found!");
            }
        }
    }

}
