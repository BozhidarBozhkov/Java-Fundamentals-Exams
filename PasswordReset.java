import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scanner.nextLine());

        String line = scanner.nextLine();
        while (!line.equals("Done")){
            String[] tokens = line.split("\\s");
            String command = tokens[0];
            switch (command){
                case "TakeOdd":
                    for (int i = 0; i < password.length(); i++) {
                        password.deleteCharAt(i);
                    }
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    password.delete(index, index + length);
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substr = tokens[1];
                    String replaced = tokens[2];
                    if (password.toString().equals(password.toString().replace(substr, replaced))){
                        System.out.println("Nothing to replace!");
                    } else {
                        password = new StringBuilder(password.toString().replace(substr, replaced));
                        System.out.println(password);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
            line = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }

}
