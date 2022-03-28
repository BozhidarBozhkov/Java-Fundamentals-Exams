import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeed {
    static class Car{
        String carModel;
        int mileage;
        int fuel;

        public Car(String carModel, int mileage, int fuel) {
            this.carModel = carModel;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public String getCarModel() {
            return carModel;
        }

        public void setCarModel(String carModel) {
            this.carModel = carModel;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\|");
            String carModel = line[0];
            int mileage = Integer.parseInt(line[1]);
            int fuel = Integer.parseInt(line[2]);

            Car cars = new Car(carModel, mileage, fuel);
            carMap.put(carModel, new Car(carModel, mileage, fuel));
        }
        String[] line = scanner.nextLine().split("\\s:\\s");
        while (!"Stop".equals(line[0])){
            String command = line[0];
            String carModel = line[1];
            switch (command){
                case "Drive":
                    int distance = Integer.parseInt(line[2]);
                    int usedFuel = Integer.parseInt(line[3]);
                    if (usedFuel > carMap.get(carModel).getFuel()){
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        int newMileage = carMap.get(carModel).getMileage() + distance;
                        carMap.get(carModel).setMileage(newMileage);
                        int newFuel = carMap.get(carModel).getFuel() - usedFuel;
                        carMap.get(carModel).setFuel(newFuel);
                        System.out.println(carModel + " driven for " + distance +
                                " kilometers. "+ usedFuel +" liters of fuel consumed.");
                    }
                    if (carMap.get(carModel).getMileage() >= 100000){
                        carMap.remove(carModel);
                        System.out.printf("Time to sell the %s!%n", carModel);
                    }
                    break;
                case "Refuel":
                    int fuel = Integer.parseInt(line[2]);
                    if (carMap.get(carModel).getFuel() + fuel > 75){
                        fuel = 75 - carMap.get(carModel).getFuel();
                        carMap.get(carModel).setFuel(75);
                    } else {
                        carMap.get(carModel).setFuel(carMap.get(carModel).getFuel() + fuel);
                    }

                    System.out.printf("%s refueled with %d liters%n", carModel, fuel);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(line[2]);
                    carMap.get(carModel).setMileage(carMap.get(carModel).getMileage() - kilometers);
                    if (carMap.get(carModel).getMileage() < 10000){
                        carMap.get(carModel).setMileage(10000);
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", carModel, kilometers);
                    }
                    break;
            }

            line = scanner.nextLine().split("\\s:\\s");
        }
        carMap.forEach((key, value) -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n"
        ,value.getCarModel(), value.getMileage(), value.getFuel()));

    }

}
