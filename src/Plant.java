public class Plant {
    int statusTumbuh; // 0-4
    int jumlahAir;
    int jumlahPupuk;

    public void beriAir() {
        jumlahAir++;
        cekKondisiTumbuh();
    }

    public void beriPupuk() {
        jumlahPupuk++;
        cekKondisiTumbuh();
    }

    public void cekKondisiTumbuh() {
        // cek kecukupan air dan pupuk
        if ((jumlahAir >= 3) && (jumlahPupuk >= 1)) tumbuh(); // trigger tumbuh()
    }

    public void tumbuh() {
        if (statusTumbuh < 4) {
            jumlahAir -= 3; // Same as jumlahAir = jumlahAir - 3
            jumlahPupuk -= 1; // Same as jumlahPupuk = jumlahPupuk - 1
            statusTumbuh++;
        }
    }

    public void displayPlant() {
        System.out.println(getStatusTumbuhText() + " (" + getStatusTumbuh() + ")\n");
        System.out.println("Jumlah air      : " + jumlahAir);
        System.out.println("Jumlah pupuk    : " + jumlahPupuk);
    }

    public String getStatusTumbuhText() {
        switch(statusTumbuh) {
            case 0: return "Benih"; // 0
            case 1: return "Tunas"; // 1
            case 2: return "Tanaman Kecil"; // 2
            case 3: return "Tanaman Dewasa"; // 3
        }

        return "Berbunga"; // 4
    }

    public int getStatusTumbuh() {
        return statusTumbuh;
    }

    // getImagePath tidak dimasukkan karena ini adalah CLI

    public Plant() { // Constructor
        statusTumbuh = 0;
        jumlahAir = 0;
        jumlahPupuk = 0;
    }
}
