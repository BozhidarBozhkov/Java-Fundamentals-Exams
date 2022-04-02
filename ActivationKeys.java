import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rawKey = scanner.nextLine();
        String line = scanner.nextLine();

        while (!line.equals("Generate")) {
            String[] data = line.split(">>>");
            String command = data[0];
            switch (command) {
                case "Contains":
                    String substring = data[1];
                    if (rawKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", rawKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String action = data[1];
                    int start = Integer.parseInt(data[2]);
                    int end = Integer.parseInt(data[3]);
                    String toChange = rawKey.substring(start, end);
                    if (action.equals("Upper")) {
                        rawKey = rawKey.substring(0, start) + rawKey.substring(start, end).toUpperCase() + rawKey.substring(end);
                    } else {
                        rawKey = rawKey.substring(0, start) + rawKey.substring(start, end).toLowerCase() + rawKey.substring(end);
                    }
                    System.out.println(rawKey);
                    break;
                case "Slice":
                    start = Integer.parseInt(data[1]);
                    end = Integer.parseInt(data[2]);
                    rawKey = rawKey.substring(0, start) + rawKey.substring(end);
                    System.out.println(rawKey);
                    break;
            }

            line = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + rawKey);

    }
}

