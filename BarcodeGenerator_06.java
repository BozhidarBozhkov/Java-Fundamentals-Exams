import java.util.Scanner;

public class BarcodeGenerator_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNum = Integer.parseInt(scanner.nextLine());
        int finishNum = Integer.parseInt(scanner.nextLine());

        int firstStart = startNum / 1000;
        int secondStart = (startNum / 100) % 10;
        int thirdStart = (startNum / 10) % 10;
        int fourthStart = startNum % 10;

        int firstFinish = finishNum / 1000;
        int secondFinish = (finishNum / 100) % 10;
        int thirdFinish = (finishNum / 10) % 10;
        int fourthFinish = finishNum % 10;

            for (int i = firstStart; i <= firstFinish; i++) {
                for (int j = secondStart; j <= secondFinish; j++) {
                    for (int k = thirdStart; k <= thirdFinish; k++) {
                        for (int l = fourthStart; l <= fourthFinish; l++) {
                            boolean isValid = (l % 2 == 1) && (k % 2 == 1) && (j % 2 == 1) && (i % 2 == 1);
                            if (isValid) {
                                System.out.printf("%d%d%d%d ", i, j, k, l);
                            }
                        }
                    }
                }
            }
    }
}
