import java.util.Scanner;

public class StringManipulatorOld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = "";
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Add":
                    String substr = data[1];
                    line = line.concat(substr);
                    break;
                case "Upgrade":
                    String symbol = data[1];
                    String toReplace = (char) (symbol.charAt(0) + 1) + "";
                    line = line.replace(symbol, toReplace);
                    break;
                case "Print":
                    System.out.println(line);
                    break;
                case "Index":
                    char symbolOccured = data[1].charAt(0);
                    if (line.contains(String.valueOf(symbolOccured))) {
                        for (int i = 0; i < line.length(); i++) {
                            if (line.charAt(i) == symbolOccured) {
                                System.out.print(i + " ");
                            }
                        }
                        System.out.println();
                    } else {
                        System.out.println("None");
                    }
                    break;
                case "Remove":
                    substr = data[1];
                    line = line.replace(substr, "");
                    break;
            }

            input = scanner.nextLine();
        }
    }

}
