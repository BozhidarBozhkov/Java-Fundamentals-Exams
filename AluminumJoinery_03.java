import java.util.Scanner;

public class AluminumJoinery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int joineryNumber = Integer.parseInt(scanner.nextLine());
        String typeOfJoinery = scanner.nextLine();
        String delivery = scanner.nextLine();

        double orderPrice = 0;
        double totalPrice = 0;

        if (joineryNumber < 10){
            System.out.println("Invalid order");
            return;
        }
        switch (typeOfJoinery){
            case "90X130":
                orderPrice = joineryNumber * 110.00;
                if (joineryNumber > 30 && joineryNumber <= 60){
                    orderPrice = orderPrice * 0.95;
                }
                else if (joineryNumber > 60) {
                    orderPrice = orderPrice * 0.92;
                }
                break;
            case "100X150":
                orderPrice = joineryNumber * 140.00;
                if (joineryNumber > 40 && joineryNumber <= 80){
                    orderPrice = orderPrice * 0.94;
                }
                else if (joineryNumber > 80){
                    orderPrice = orderPrice * 0.9;
                }
                break;
            case "130X180":
                orderPrice = joineryNumber * 190.00;
                if (joineryNumber > 20 && joineryNumber <= 50){
                    orderPrice = orderPrice * 0.93;
                }
                else if (joineryNumber > 50){
                    orderPrice = orderPrice * 0.88;
                }
                break;
            case "200X300":
                orderPrice = joineryNumber * 250.00;
                if (joineryNumber > 25 && joineryNumber <= 50){
                    orderPrice = orderPrice * 0.91;
                }
                else if (joineryNumber > 50){
                    orderPrice = orderPrice * 0.86;
                }
                break;
        }
        if (delivery.equals("With delivery")){
            totalPrice = orderPrice + 60;
            if (joineryNumber > 99){
                totalPrice = totalPrice * 0.96;
            }
        } else {
            totalPrice = orderPrice;
            if (joineryNumber > 99){
                totalPrice = totalPrice * 0.96;
            }
        }
        System.out.printf("%.2f BGN", totalPrice);
    }
}
