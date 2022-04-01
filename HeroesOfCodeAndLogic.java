import java.util.*;

public class HeroesOfCodeAndLogic {
    static class Hero {
        String name;
        int hitPoints;
        int manaPoints;

        public Hero(String name, int hitPoints, int manaPoints) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.manaPoints = manaPoints;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHitPoints() {
            return hitPoints;
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }

        public int getManaPoints() {
            return manaPoints;
        }

        public void setManaPoints(int manaPoints) {
            this.manaPoints = manaPoints;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Hero> hero = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            String heroName = line[0];
            int hitPoints = Integer.parseInt(line[1]);
            int manaPoints = Integer.parseInt(line[2]);

            Hero heroes = new Hero(heroName, hitPoints, manaPoints);
            hero.put(heroName, new Hero(heroName, hitPoints, manaPoints));
        }
        int maxHitPoints = 100;
        int maxManaPoints = 200;
        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] line = input.split(" - ");
            String command = line[0];
            String name = line[1];
            Hero currentHero = hero.get(name);
            switch (command) {
                case "CastSpell":
                    int manaNeeded = Integer.parseInt(line[2]);
                    String spellName = line[3];
                    if (currentHero.getManaPoints() - manaNeeded >= 0) {
                        currentHero.setManaPoints(currentHero.getManaPoints() - manaNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n", name, spellName, currentHero.getManaPoints());
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(line[2]);
                    String attacker = line[3];
                    if (currentHero.getHitPoints() - damage > 0) {
                        currentHero.setHitPoints(currentHero.getHitPoints() - damage);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n", name, damage, attacker, currentHero.getHitPoints());
                    } else {
                        hero.remove(name);
                        System.out.printf("%s has been killed by %s!%n", name, attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(line[2]);
                    if (currentHero.getManaPoints() + amount < maxManaPoints) {
                        currentHero.setManaPoints(currentHero.getManaPoints() + amount);
                    } else {
                        amount = 200 - currentHero.getManaPoints();
                        currentHero.setManaPoints(200);
                    }
                    System.out.printf("%s recharged for %d MP!%n", name, amount);
                    break;
                case "Heal":
                    int heal = Integer.parseInt(line[2]);
                    if (currentHero.getHitPoints() + heal < maxHitPoints){
                        currentHero.setHitPoints(currentHero.getHitPoints() + heal);
                    } else {
                        heal = 100 - currentHero.getHitPoints();
                        currentHero.setHitPoints(100);
                    }
                    System.out.printf("%s healed for %d HP!%n", name, heal);
                    break;

            }
        }
       hero.forEach((k,v) -> {
           System.out.println(k);
           System.out.println("HP: " + v.getHitPoints());
           System.out.println("MP: " + v.getManaPoints());
       });
    }

}
