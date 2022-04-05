import java.util.Locale;
import java.util.Scanner;

public class DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String line = scanner.nextLine();

        while (!line.equals("Finish")) {
            String[] data = line.split("\\s+");
            String command = data[0];
            switch (command) {
                case "Replace":
                    String current = data[1];
                    String replace = data[2];
                    int index = text.indexOf(current);
                    while (index != -1) {
                        text = text.replace(current, replace);
                        index = text.indexOf(current);
                    }
                    System.out.println(text);
                    break;
                case "Cut":
                    int start = Integer.parseInt(data[1]);
                    int end = Integer.parseInt(data[2]) + 1;
                    StringBuilder sb = new StringBuilder(text);
                    if (end > sb.length()){
                        System.out.println("Invalid indices!");
                    } else {
                        sb.delete(start, end);
                        text = sb.toString();
                        System.out.println(text);
                    }
                    break;
                case "Make":
                    String action = data[1];
                    if (action.equals("Upper")) {
                        text = text.toUpperCase();
                    } else {
                        text = text.toLowerCase();
                    }
                    System.out.println(text);
                    break;
                case "Check":
                    String check = data[1];
                    if (text.contains(check)) {
                        System.out.println("Message contains " + check);
                    } else {
                        System.out.println("Message doesn't contain " + check);
                    }
                    break;
                case "Sum":
                    start = Integer.parseInt(data[1]);
                    end = Integer.parseInt(data[2]);
                    int sum = 0;
                    char[] textToChar = text.toCharArray();
                    if (start >= 0 && end >= 0 && end <= textToChar.length) {
                        for (int i = start; i < end; i++) {
                            sum += textToChar[i];
                        }
                        System.out.println(sum);
                    } else{
                        System.out.println("Invalid indices!");
                    }
                    break;


            }

            line = scanner.nextLine();
        }
    }

}
