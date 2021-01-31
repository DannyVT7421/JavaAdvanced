package MultidimensionalArrays;

import java.util.Scanner;

public class Ex08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerHealth = 18500;
        double bossHealth = 3000000;
        double damage = Double.parseDouble(scanner.nextLine());

        int[] playerPosition = new int[2];
        playerPosition[0] = 7;
        playerPosition[1] = 7;

        boolean isInCloud = false;
        String lastSpell = "";
        while (playerHealth > 0) {
            bossHealth -= damage;

            if (isInCloud) {
                playerHealth -= 3500;
                isInCloud = false;
            }
            if (playerHealth <= 0) {
                lastSpell = "Cloud";
                break;
            }
            if (bossHealth <= 0) {
                break;
            }
            String[] tokens = scanner.nextLine().split("\\s+");

            String spell = tokens[0];
            int targetRow = Integer.parseInt(tokens[1]);
            int targetCol = Integer.parseInt(tokens[2]);
            lastSpell = spell;
            boolean isPlayerDamaged = checkPlayerIsHit(playerPosition[0], playerPosition[1], targetRow, targetCol);

            int damageDone = 0;
            if (isPlayerDamaged) {
                switch (spell) {
                    case "Cloud":
                        damageDone = 3500;
                        break;
                    case "Eruption":
                        damageDone = 6000;
                        break;
                }
                boolean canMove = canMoveAndMovePlayer(playerPosition, targetRow, targetCol);
                if (!canMove) {
                    playerHealth -= damageDone;
                    if (spell.equals("Cloud")) {
                        isInCloud = true;
                    }
                }
            }
        }
        if (bossHealth > 0) {
            System.out.printf("Heigan: %.2f%n", bossHealth);
        } else {
            System.out.println("Heigan: Defeated!");

        }
        if (playerHealth <= 0) {
            lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : lastSpell;
            System.out.printf("Player: Killed by %s%n", lastSpell);
        } else {
            System.out.printf("Player: %d%n", playerHealth);
        }
        System.out.println(String.format("Final position: %d, %d", playerPosition[0], playerPosition[1]));
    }

    private static boolean canMoveAndMovePlayer(int[] position, int row, int col) {

        boolean canMove = true;

        int r = position[0];
        int c = position[1];
        if (isInBound(r - 1, c) && !checkPlayerIsHit(r - 1, c, row, col)) {
            r--;
        } else if (isInBound(r, c + 1) && !checkPlayerIsHit(r, c + 1, row, col)) {
            c++;
        } else if (isInBound(r + 1, c) && !checkPlayerIsHit(r + 1, c, row, col)) {
            r++;
        } else if (isInBound(r, c - 1) && !checkPlayerIsHit(r, c - 1, row, col)) {
            c--;
        } else {
            canMove = false;
        }
        position[0] = r;
        position[1] = c;
        return canMove;
    }

    private static boolean isInBound(int r, int c) {
        return r >= 0 && r < 15 && c >= 0 && c < 15;
    }

    private static boolean checkPlayerIsHit(int r, int c, int targetRow, int targetCol) {
        return r >= targetRow - 1 && r <= targetRow + 1
                && c >= targetCol - 1 && c <= targetCol + 1;
    }
}
