import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String line = scanner.nextLine();

        while (!line.equals("For Azeroth")){
            String[] data = line.split("\\s+");
            String command = data[0];

            switch (command){
                case "GladiatorStance":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;
                case "DefensiveStance":
                    text = text.toLowerCase();
                    System.out.println(text);
                    break;
                case "Dispel":
                    int index = Integer.parseInt(data[1]);
                    char letter = data[2].charAt(0);
                    StringBuilder sb = new StringBuilder(text);
                    if (index >= 0 && index < text.length()){
                        sb.setCharAt(index, letter);
                        text = sb.toString();
                        System.out.println("Success!");
                    } else {
                        System.out.println("Dispel too weak.");
                    }
                    break;
                case "Target":
                    String command1 = data[1];
                    if (command1.equals("Change")){
                        String first = data[2];
                        String second = data[3];
                        if (text.contains(first)){
                            text = text.replace(first, second);
                        }
                        System.out.println(text);
                    } else if (command1.equals("Remove")){
                        String substr = data[2];
                        String replaceSubstr = text.replace(substr, "");
                        if (text.contains(substr)){
                            text = replaceSubstr;
                            System.out.println(text);
                        }
                    }
                    break;
                default:
                    System.out.println("Command doesn't exist!");
                    break;
            }

            line = scanner.nextLine();
        }
    }

}
