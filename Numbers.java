import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!line.equals("Finish")){
            String[] data = line.split(" ");
            String command = data[0];
            int value = Integer.parseInt(data[1]);

            switch (command){
                case "Add":
                    numbers.add(value);
                    break;
                case "Remove":
                    int temp = numbers.indexOf(value);
                    numbers.remove(temp);
                    break;
                case "Replace":
                    if (numbers.contains(value)){
                        int temp1 = numbers.indexOf(value);
                        numbers.set(temp1, Integer.parseInt(data[2]));
                    }
                    break;
                case "Collapse":
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) < value){
                            numbers.remove(i);
                            i--;
                        }
                    }
                    break;
            }

            line = scanner.nextLine();
        }

        String separator = " ";
        printArray(numbers, separator);

    }
    public static void printArray(List<Integer> numbers, String separator){
        for (int i = 0; i < numbers.size() ; i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1){
                System.out.print(separator);
            }
        }
    }
}
