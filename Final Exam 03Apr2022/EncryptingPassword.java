import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^(.*)>(?<num>\\d+)\\|(?<low>[a-z]+)\\|(?<upper>[A-Z]+)\\|(?<symbols>[^<>]+)<\\1$";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder validPass = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
                validPass.append(matcher.group("num"));
                validPass.append(matcher.group("low"));
                validPass.append(matcher.group("upper"));
                validPass.append(matcher.group("symbols"));
                System.out.println("Password: " + validPass);
                validPass.setLength(0);

            } else {
                System.out.println("Try another password!");
            }

        }
    }

}
