import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(?<name>[A-Z][a-z]{2,} [A-Z][a-z]{2,})#+(?<jobPosition>([A-Z][a-z]+&?){1,3})\\d{2}(?<companyName>[A-Z][A-z\\d]+ ((Ltd.)|(JSC)))";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){
                String name = matcher.group("name");
                String job = matcher.group("jobPosition");
                String replace = job.replace("&", " ");
                String company = matcher.group("companyName");
                System.out.printf("%s is %s at %s\n", name, replace, company);
            }
        }
    }

}
