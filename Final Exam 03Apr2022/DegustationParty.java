import java.util.*;

public class DegustationParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, ArrayList<String>> likedMeals = new LinkedHashMap<>();
        int count = 0;

        while (!line.equals("Stop")) {
            String[] data = line.split("-");
            String command = data[0];
            String guest = data[1];
            String meal = data[2];
            if (command.equals("Like") && !likedMeals.containsKey(guest)) {
                likedMeals.put(guest, new ArrayList<>());
            }
            switch (command) {
                case "Like":
                    if (likedMeals.containsKey(guest)
                            && !likedMeals.get(guest).contains(meal)) {
                        likedMeals.get(guest).add(meal);
                    }
                    break;
                case "Dislike":
                    if (likedMeals.containsKey(guest)) {
                        if (likedMeals.get(guest).contains(meal)) {
                            likedMeals.get(guest).remove(meal);
                            System.out.println(guest + " doesn't like the " +
                                    meal + ".");
                            count++;
                        } else {
                            System.out.println(guest + " doesn't have the " + meal + " in his/her collection.");
                        }
                    } else {
                        System.out.println(guest + " is not at the party.");
                    }
                    break;
            }
            line = scanner.nextLine();
        }
         for(Map.Entry<String, ArrayList<String>> entry : likedMeals.entrySet()){
          System.out.println(entry.getKey() + ":" + String.join(", ", entry.getValue()));
    }

        System.out.printf("Unliked meals: %d%n",count);
}

}
