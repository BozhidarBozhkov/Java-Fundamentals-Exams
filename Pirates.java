import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    static class City{
        String name;
        int population;
        int gold;

        public City(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, City> cityMap = new LinkedHashMap<>();
        while (!line.equals("Sail")){
            String[] data = line.split("\\|\\|");
            String cityName = data[0];
            int population = Integer.parseInt(data[1]);
            int gold = Integer.parseInt(data[2]);

            City cities = new City(cityName, population, gold);
            if (!cityMap.containsKey(cityName)){
                cityMap.put(cityName, cities);
            } else {
                cityMap.get(cityName).setPopulation(cities.getPopulation() + population);
                cityMap.get(cityName).setGold(cities.getGold() + gold);
            }

            line = scanner.nextLine();
        }
        line = scanner.nextLine();
        while (!line.equals("End")){
            String[] tokens = line.split("=>");
            String command = tokens[0];
            String town = tokens[1];

            switch (command){
                case "Plunder":
                    int people = Integer.parseInt(tokens[2]);
                    int gold = Integer.parseInt(tokens[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                    int population = cityMap.get(town).getPopulation() - people;
                    cityMap.get(town).setPopulation(population);
                    int goldLeft = cityMap.get(town).getGold() - gold;
                    cityMap.get(town).setGold(goldLeft);
                    if (population == 0 || goldLeft == 0){
                        cityMap.remove(town);
                        System.out.println(town + " has been wiped off the map!");
                    }
                    break;
                case "Prosper":
                    gold = Integer.parseInt(tokens[2]);
                    if (gold < 0){
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        int increaseGold = cityMap.get(town).getGold() + gold;
                        cityMap.get(town).setGold(increaseGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, increaseGold);
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        if (cityMap.size() == 0){
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cityMap.size());
            cityMap.forEach((k, v) -> System.out.println(k + " -> Population: " + v.getPopulation() + " citizens, Gold: " + v.getGold() + " kg"));
        }
    }

}
