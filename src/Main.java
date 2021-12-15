import java.util.Scanner; // Import Scanner library

public class Main {
    private static Garden garden;

    public static void main(String[] args) {
        garden = new Garden("MiGarden");
        Scanner sc = new Scanner(System.in);

        for (;;) {
            MyUtils.clearScreen(); // Clear screen

            garden.displayPlants();
            System.out.println("\nMasukkan:");
            System.out.println("1 untuk memberi air");
            System.out.println("2 untuk memberi pupuk");
            System.out.println("5 untuk tanam benih baru");
            System.out.println("7 untuk memanen");
            System.out.println("9 untuk keluar dari program\n");

            int input = sc.nextInt(); // Scan user input
            switch (input) {
                case 1:
                    garden.waterPlants(); // Tambah air
                    break;

                case 2:
                    garden.fertilizePlants(); // Tambah pupuk
                    break;

                case 5:
                    garden.addPlant();
                    break;

                case 7:
                    garden.harvestPlant();
                    break;
                
                case 9:
                    sc.close();
                    System.exit(0); // Exit the program
                    break;
            }
        }
    }
}
