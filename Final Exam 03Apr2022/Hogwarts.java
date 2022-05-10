import java.util.Locale;
import java.util.Scanner;

public class Hogwarts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String spell = scanner.nextLine();
        String line = scanner.nextLine();

        while (!line.equals("Abracadabra")){
            String[] data = line.split("\\s+");
            String command = data[0];

            switch (command){
                case "Abjuration":
                    spell = spell.toUpperCase();
                    System.out.println(spell);
                    break;
                case "Necromancy":
                    spell = spell.toLowerCase();
                    System.out.println(spell);
                    break;
                case "Illusion":
                    int index = Integer.parseInt(data[1]);
                    char letter = data[2].charAt(0);
                    StringBuilder sb = new StringBuilder(spell);
                    if (index >= 0 && index < spell.length()){
                        sb.setCharAt(index, letter);
                        spell = sb.toString();
                        System.out.println("Done!");
                    } else {
                        System.out.println("The spell was too weak.");
                    }
                    break;
                case "Divination":
                    String first = data[1];
                    String second = data[2];
                    if (spell.contains(first)){
                        spell = spell.replace(first, second);
                        System.out.println(spell);
                    }
                    break;
                case "Alteration":
                    String substr = data[1];
                    String replaceSubstr = spell.replace(substr, "");
                    if (spell.contains(substr)){
                        spell = replaceSubstr;
                        System.out.println(spell);
                    }
                    break;
                default:
                    System.out.println("The spell did not work!");
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
