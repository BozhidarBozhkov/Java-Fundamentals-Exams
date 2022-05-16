    import java.util.Scanner;

    public class TrekkingMania_04 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int groupNumber = Integer.parseInt(scanner.nextLine());

            int allPeople = 0;
            int peopleMusala = 0;
            int peopleMonblan = 0;
            int peopleKilimandjaro = 0;
            int peopleK2 = 0;
            int peopleEverest = 0;
            for (int i = 1; i <=groupNumber ; i++) {
                int peoplePerGroup = Integer.parseInt(scanner.nextLine());
                allPeople += peoplePerGroup;
                if (peoplePerGroup <= 5){
                    peopleMusala += peoplePerGroup;

                } else if (peoplePerGroup >= 6 && peoplePerGroup <= 12){
                    peopleMonblan += peoplePerGroup;

                }else if (peoplePerGroup >= 13 && peoplePerGroup <= 25){
                    peopleKilimandjaro += peoplePerGroup;
                }else if (peoplePerGroup >= 26 && peoplePerGroup <= 40){
                    peopleK2 += peoplePerGroup;

                }else {
                    peopleEverest += peoplePerGroup;

                }
            }
            System.out.printf("%.2f%%%n", peopleMusala * 1.0 / allPeople * 100);
            System.out.printf("%.2f%%%n", peopleMonblan * 1.0 / allPeople * 100);
            System.out.printf("%.2f%%%n", peopleKilimandjaro * 1.0 / allPeople * 100);
            System.out.printf("%.2f%%%n", peopleK2 * 1.0 / allPeople * 100);
            System.out.printf("%.2f%%%n", peopleEverest * 1.0 / allPeople * 100);

        }
    }
