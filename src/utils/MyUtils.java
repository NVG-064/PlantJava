package utils;

public class MyUtils {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public static int generateRandomInt(int min, int max) {
        int rnd = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return rnd;
    }
}
