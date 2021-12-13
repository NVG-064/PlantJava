import java.util.Scanner; // Import Scanner library

public class PlantMain {
    static Scanner sc = new Scanner(System.in); // Membuat scanner baru bernama sc
    public static void main(String[] myString) {
        int hasilRandom = -1;
        int exceptionFlag = 0; // Anggaplah program berjalan dengan benar pada saat pertama kali dijalankan
        for (;;) {
            if (hasilRandom == -1) {
                RandomNumber rn = new RandomNumber();
                hasilRandom = rn.createRandomNumber(0, 1);
            }

            if (hasilRandom == 0) {
                Fruit fruit = new Fruit(); // Create new Fruit Class called p

                for (;;) {
                    try {
                        if (exceptionFlag == 1) {
                            showExceptionText(exceptionFlag);
                            Thread.sleep(2000); // Pause system to 2 secs
                        } // If
        
                        showMainPage();;
                        fruit.displayPlant(); // Display Plant
                        System.out.println("\n\nMasukkan:\n0 untuk memberi air\n1 untuk memberi pupuk\n5 untuk tebang tanaman dan tanam benih baru\n7 untuk keluar dari program\n");
                        int input = sc.nextInt(); // Scan user input
                        switch(input) {
                            case 0:
                                fruit.beriAir(); // Add Air
                                break;
                            
                            case 1:
                                fruit.beriPupuk(); // Add Pupuk
                                break;
        
                            case 5:
                                fruit.resetTanam(); // Reset program
                                Thread.sleep(2000); // Pause system to 2 secs
                                main(myString);
                                break;
                            
                            case 7:
                                System.exit(0); // Equals to return 0 in C++
                                break;
                        } // Switch
        
                        exceptionFlag = 0; // Return back to 0 to avoid message printing
        
                        // Try
                    } catch (Exception nonIntegerInput) { // Action if we wrong input program
                        sc.nextLine(); // Clear the Scanner
                        exceptionFlag = 1; // Trigger the flag to show Exception messages
                    } // Catch
                }
            } // If

            else if (hasilRandom == 1) {
                Flower flower = new Flower();

                for (;;) {
                    try {
                        if (exceptionFlag == 1) {
                            showExceptionText(exceptionFlag);
                            Thread.sleep(2000); // Pause system to 2 secs
                        } // If
        
                        showMainPage();
                        flower.displayPlant(); // Display Plant
                        System.out.println("\n\nMasukkan:\n0 untuk memberi air\n1 untuk memberi pupuk\n5 untuk tebang tanaman dan tanam benih baru\n7 untuk keluar dari program\n");
                        int input = sc.nextInt(); // Scan user input
                        switch(input) {
                            case 0:
                                flower.beriAir(); // Add Air
                                break;
                            
                            case 1:
                                flower.beriPupuk(); // Add Pupuk
                                break;
        
                            case 5:
                                flower.resetTanam(); // Reset program
                                Thread.sleep(2000); // Pause system to 2 secs
                                main(myString);
                                break;
                            
                            case 7:
                                System.exit(0); // Equals to return 0 in C++
                                break;
                        } // Switch
        
                        exceptionFlag = 0; // Return back to 0 to avoid message printing
        
                        // Try
                    } catch (Exception nonIntegerInput) { // Action if we wrong input program
                        sc.nextLine(); // Clear the Scanner
                        exceptionFlag = 1; // Trigger the flag to show Exception messages
                    } // Catch
                }
            } // Else If
        } // For
    } // Main()

    static void showMainPage() {
        System.out.print("\033[H\033[2J"); // Clear screen
        System.out.println("\t\tMiGarden\n");
    }

    static void showExceptionText(int flags) {
        if (flags == 1) {
            System.out.print("\033[H\033[2J"); // Clear screen
            System.out.print("Wrong input (non integer) found. Try to input again."); // Exception messages goes here
        }
    }
} // Class PlantMain