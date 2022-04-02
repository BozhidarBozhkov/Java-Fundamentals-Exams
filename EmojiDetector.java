import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([:]{2}|[**]{2})(?<emoji>[A-Z][a-z]{2,})\\1";

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
            String emoji = matcher.group("emoji");
            emojies.add(emoji);
        }
        StringBuilder coolEmoji = new StringBuilder();
        for (String emoji : emojies) {
            int coolness = 0;
            for (int i = 0; i < emoji.length(); i++) {
                coolness += emoji.charAt(i);
            }
            if (coolness > coolTreshold){
                coolEmoji.append(emoji);
            }
        }
        System.out.println("Cool threshold: " + coolTreshold);
        System.out.println(emojies.size() + " emojis found in the text. The cool ones are:");
        emojies.forEach(System.out::println);

    }

}
