import java.util.Scanner; // Import Scanner library

public class Main {

    private static Plant plant;
    private static Garden garden;

    public static void main(String[] args) {
        garden = new Garden();
        Scanner sc = new Scanner(System.in);
        initPlant();
        //index++;

        for (;;) {
            MyUtils.clearScreen(); // Clear screen
            System.out.println("\t\tMiGarden\n");

            garden.displayPlant();
            // plant.displayPlant(); // Display Plant
            System.out.println("\nMasukkan:");
            System.out.println("1 untuk memberi air");
            System.out.println("2 untuk memberi pupuk");
            System.out.println("5 untuk tanam benih baru");
            System.out.println("7 untuk keluar dari program\n");

            int input = sc.nextInt(); // Scan user input
            switch (input) {
                case 1:
                    plant.giveWater(); // Tambah air
                    break;

                case 2:
                    plant.giveFertilizer(); // Tambah pupuk
                    break;

                case 5:
                    initPlant();
                    break;

                case 7:
                    sc.close();
                    System.exit(0); // Exit the program
                    break;
            }
        }
    }

    static void initPlant() {
        int num = MyUtils.generateRandomInt(0, 1);
        if (num == 0) {
            plant = new Fruit();
            garden.addPlant(plant, num);
        }
        else {
            plant = new Flower();
            garden.addPlant(plant, num);
        }
    }
}
