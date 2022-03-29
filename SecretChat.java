import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String[] instructions = scanner.nextLine().split(":\\|:");
        while (!instructions[0].equals("Reveal")){
            String command = instructions[0];
            switch (command){
                case "InsertSpace":
                    int index = Integer.parseInt(instructions[1]);
                    message.insert(index, " ");
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substr = instructions[1];
                    if (!message.toString().contains(substr)){
                        System.out.println("error");
                    } else {
                        int startIndex = message.indexOf(substr);
                        int endIndex = startIndex + substr.length() + 1;
                        String reversed = "";
                        for (int i = 0; i < substr.length(); i++) {
                            char symbol = substr.charAt(i);
                            reversed = symbol + reversed;
                        }
                        message.delete(startIndex, endIndex);
                        message.append(reversed);
                        System.out.println(message);
                    }
                    break;
                case "ChangeAll":
                    substr = instructions[1];
                    String replacement = instructions[2];
                    index = message.indexOf(substr);
                    while (index != -1){
                        message.replace(index, index + substr.length(), replacement);
                        index = message.indexOf(substr);
                    }
                    System.out.println(message);
                    break;

            }
//            System.out.println(message);
            instructions = scanner.nextLine().split(":\\|:");
        }
        System.out.printf("You have a new text message: %s%n", message);
    }

}
