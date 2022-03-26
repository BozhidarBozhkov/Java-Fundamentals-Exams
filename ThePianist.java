import java.util.*;

public class ThePianist {
    static class Piece {
        String piece;
        String composer;
        String key;

        public Piece(String piece, String composer, String key) {
            this.piece = piece;
            this.composer = composer;
            this.key = key;
        }

        public String getPiece() {
            return piece;
        }

        public void setPiece(String piece) {
            this.piece = piece;
        }

        public String getComposer() {
            return composer;
        }

        public void setComposer(String composer) {
            this.composer = composer;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

//        @Override
//        public String toString() {
//            return String.format("%s -> Composer: %s, Key: %s", this.piece, this.composer, this.key);
//        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Piece> piecesList = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\|");
            String piece = line[0];
            String composer = line[1];
            String key = line[2];

            Piece pieces = new Piece(piece, composer, key);
            piecesList.put(piece, new Piece(piece, composer, key));
        }
        String[] line = scanner.nextLine().split("\\|");
        while (!line[0].equals("Stop")) {
            String command = line[0];
            String piece = line[1];
            switch (command) {
                case "Add":
                    String composer = line[2];
                    String key = line[3];
                    if (piecesList.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                        line = scanner.nextLine().split("\\|");
                        continue;
                    }
                    Piece pieces = new Piece(piece, composer, key);
                    piecesList.put(piece, new Piece(piece, composer, key));
                    System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    break;
                case "Remove":
                    if (piecesList.containsKey(piece)) {
                        piecesList.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = line[2];
                    if (piecesList.containsKey(piece)){
                        piecesList.get(piece).setKey(newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }

            line = scanner.nextLine().split("\\|");
        }
        piecesList.entrySet().forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().getComposer(), entry.getValue().getKey()));
    }

}
