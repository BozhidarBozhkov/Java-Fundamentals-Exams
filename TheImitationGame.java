import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Decode")) {
            String[] data = command.split("\\|");

            switch (data[0]) {
                case "Move":
                    message = move(message, Integer.parseInt(data[1]));
                    break;
                case "Insert":
                    message = insert(message, Integer.parseInt(data[1]), data[2]);
                    break;
                case "ChangeAll":
                    message = changeAll(message, data[1], data[2]);
                    break;

            }

            command = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + message);
    }

    private static String changeAll(String message, String substr, String replacement) {
        return message.replace(substr, replacement);
    }

    private static String insert(String message, int index, String substr) {
        String firstPart = message.substring(0, index);
        String secondPart = message.substring(index);
        return firstPart + substr + secondPart;
    }

    private static String move(String message, int length) {
        String firstPart = message.substring(0, length);
        String secondPart = message.substring(length);
        return secondPart + firstPart;
    }

}
