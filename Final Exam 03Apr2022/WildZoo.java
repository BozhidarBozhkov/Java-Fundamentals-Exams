import java.util.*;

public class WildZoo {
    static class Animal {
        String name;
        int food;
        String area;

        public Animal(String name, int food, String area) {
            this.name = name;
            this.food = food;
            this.area = area;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getFood() {
            return food;
        }

        public void setFood(int food) {
            this.food = food;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }
    }
    static class Area {
        List<Animal> animalList;

        public Area(List<Animal> animalList) {
            this.animalList = animalList;
        }

        public List<Animal> getAnimalList() {
            return animalList;
        }

        public void setAnimalList(List<Animal> animalList) {
            this.animalList = animalList;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Animal> animals = new LinkedHashMap<>();
        Map<String, Area> areas = new LinkedHashMap<>();

        while (!line.equals("EndDay")){
            String[] data = line.split(":\\s+|-");
            String command = data[0];
            String animalName = data[1];
            switch (command){
                case "Add":
                    int foodNeeded = Integer.parseInt(data[2]);
                    String area = data[3];
                    Animal animal = new Animal(animalName, foodNeeded, area);
                    if (animals.containsKey(animalName)) {
                        animals.get(animalName).setFood(animals.get(animalName).getFood() + foodNeeded);
                        if (!areas.get(area).getAnimalList().contains(animals.get(animalName))
                        && animals.get(animalName).getFood() > 0){
                            areas.get(area).getAnimalList().add(animal);
                        }
                    } else {
                        animals.put(animalName, animal);
                        Area area1 = new Area(new ArrayList<>());
                        if (areas.containsKey(animals.get(animalName).getArea())){
                            areas.get(area).getAnimalList().add(animal);
                        } else {
                            areas.put(area, area1);
                            areas.get(area).getAnimalList().add(animal);
                        }
                    }
                    break;
                case "Feed":
                    int food = Integer.parseInt(data[2]);
                    if (animals.containsKey(animalName)){
                        animals.get(animalName).setFood(animals.get(animalName).getFood() - food);
                        if (animals.get(animalName).getFood() <= 0){
                            System.out.printf("%s was successfully fed%n", animalName);
                            areas.get(animals.get(animalName).getArea()).getAnimalList().remove(animals.get(animalName));
                        }
                    }
                    break;
            }

            line = scanner.nextLine();
        }
        System.out.println("Animals:");
        animals.forEach((k, v) -> {
            if (animals.get(k).getFood() > 0){
                System.out.printf(" %s -> %dg\n", v.getName(), v.getFood());
            }
        });
        System.out.println("Areas with hungry animals:");
        areas.forEach((k, v) -> {
            if (areas.get(k).getAnimalList().size() > 0){
                System.out.printf(" %s: %d\n", k, areas.get(k).getAnimalList().size());
            }
        });
    }
}
