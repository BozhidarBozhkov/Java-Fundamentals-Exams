import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      // String regex = "([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        String regex = "([*]{2})([A-Z][a-z]{2,})\\1|([:]{2})([A-Z][a-z]{2,})\\3";

        String line = scanner.nextLine();
        long coolTreshold = 1;
        String digitsOnly = line.replaceAll("[^0-9]", "");
        for (int i = 0; i < digitsOnly.length(); i++) {
            int currentDigit = digitsOnly.charAt(i) - '0';
            coolTreshold = currentDigit * coolTreshold;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        List<String> emojies = new ArrayList<>();
        while (matcher.find()){
            String emoji = matcher.group();
            emojies.add(emoji);
        }
        List<String> coolEmoji = new ArrayList<>();
        for (String emoji : emojies) {
            int coolness = 0;
            for (int i = 2; i < emoji.length() - 2; i++) {
                coolness += emoji.charAt(i);
            }
            if (coolness > coolTreshold){
                coolEmoji.add(emoji);
            }
        }
        System.out.println("Cool threshold: " + coolTreshold);
        System.out.println(emojies.size() + " emojis found in the text. The cool ones are:");
        coolEmoji.forEach(System.out::println);
    }
}
