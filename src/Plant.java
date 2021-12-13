public abstract class Plant {
    protected int growthStage; // 0-4
    protected String plantName;

    protected int waterCount;
    protected int fertilizerCount;

    public Plant() { // Constructor
        init();
    }

    protected void init() {
        growthStage = 0;
        waterCount = 0;
        fertilizerCount = 0;
    }

    public String getPlantName() {
        return plantName;
    }

    public int getGrowthStatus() {
        return growthStage;
    }

    public String displayGrowthStatus() {
        switch (growthStage) {
            case 0:
                return "Benih";
            case 1:
                return "Tunas";
            case 2:
                return "Tanaman Kecil";
            case 3:
                return "Tanaman Dewasa";
            case 4:
                return "Berbunga";
        }
        return "Unknown";
    }

    public void giveWater() {
        waterCount++;
        checkGrowth();
    }

    public void giveFertilizer() {
        fertilizerCount++;
        checkGrowth();
    }

    public void checkGrowth() {
        // cek kecukupan air dan pupuk
        if ((waterCount >= 3) && (fertilizerCount >= 1))
            grow(); // trigger grow()
    }

    public void grow() {
        if (growthStage < 4) {
            waterCount -= 3; // Same as jumlahAir = jumlahAir - 3
            fertilizerCount -= 1; // Same as jumlahPupuk = jumlahPupuk - 1
            growthStage++;
        }
    }

    public void displayPlant() {
        System.out.println(displayGrowthStatus() + " (Tahap " + getGrowthStatus() + ")\n");
        if (growthStage > 3)
            System.out.println("Nama Tanaman    : " + getPlantName() + "\n");
        System.out.println("Jumlah air      : " + waterCount);
        System.out.println("Jumlah pupuk    : " + fertilizerCount);
    }

    public void resetPlant() {
        init();
        MyUtils.clearScreen();
        System.out.print("Tanaman ditebang dan benih baru ditanam");
        try {
            Thread.sleep(200);
        } catch (Exception e) {

        }
    }
}
