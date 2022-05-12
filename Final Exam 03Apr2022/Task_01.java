import java.util.Scanner;

public class Task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String line = scanner.nextLine();

        while (!line.equals("For Azeroth")) {

            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "GladiatorStance": {
                    text = text.toUpperCase();
                    System.out.println(text);
                }
                break;
                case "DefensiveStance": {
                    text = text.toLowerCase();
                    System.out.println(text);
                }
                break;
                case "Dispel": {
                    int index = Integer.parseInt(tokens[1]);
                    char letter = tokens[2].charAt(0);
                    if (index < 0 || index > text.length()) {
                        System.out.println("Dispel too weak.");
                        break;
                    } else {
                        char currentChar = text.charAt(index);
                        StringBuilder stringBuilder = new StringBuilder(text);
                        stringBuilder.setCharAt(index, letter);
                        text = "";
                        text = stringBuilder.toString();
                        System.out.println("Success!");
                    }
                }
                break;
                case "Target": {
                    if (tokens[1].equals("Change")) {
                        String substring = tokens[2];
                        String secondSubstring = tokens[3];

                        if (text.contains(substring)) {
                            text = text.replace(substring, secondSubstring);
                            System.out.println(text);

                        } else {
                            break;
                        }

                    } else if (tokens[1].equals("Remove")) {
                        String substring = tokens[2];
                        if (text.contains(substring)){
                            text = text.replace(substring,"");
                            System.out.println(text);
                            break;
                        }else {
                            break;
                        }
                    } else {
                        System.out.println("Command doesn't exist!");
                        break;
                    }
                }
                break;
                default:
                    System.out.println("Command doesn't exist!");
            }
            line = scanner.nextLine();

        }
    }
}