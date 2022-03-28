import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile("([@#])(?<wordOne>[A-Za-z]{3,})\\1{2}(?<wordTwo>[a-zA-Z]{3,})\\1");
        Matcher matcher = pattern.matcher(line);

        List<String> words = new ArrayList<>();
        int count = 0;
        while (matcher.find()) {
            count++;
            StringBuilder wordOne = new StringBuilder(matcher.group("wordOne"));
            StringBuilder wordTwo = new StringBuilder(matcher.group("wordTwo"));
            
            if (wordOne.reverse().compareTo(wordTwo) == 0) {
                wordOne.reverse().append(" <=> ").append(wordTwo);
                words.add(wordOne.toString());
            }
        }
        if (count == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(count + " word pairs found!");
        }
        if (words.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", words));
        }

    }

}
