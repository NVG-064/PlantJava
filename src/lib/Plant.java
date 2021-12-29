package lib;

public abstract class Plant {
    protected int growthStage;
    protected String plantName;

    protected int waterCount;
    protected int fertilizerCount;

    // Constructor
    public Plant() {
        growthStage = 1;
        waterCount = 0;
        fertilizerCount = 0;
    }

    // Protected methods
    protected void validateGrowth() {
        // cek kecukupan air dan pupuk
        if (waterCount >= 3 && fertilizerCount >= 1) {
            onGrow();
        }
    }

    protected void onGrow() {
        if (growthStage < 5) {
            waterCount -= 3; // Sama seperti waterCount = waterCount - 3
            fertilizerCount -= 1; // Sama seperti fertilizerCount = fertilizerCount - 1
            growthStage++;
        }
    }

    // Public methods
    public String getName() {
        return plantName;
    }

    public int getGrowthStage() {
        return growthStage;
    }

    public String displayGrowthStatus() {
        switch (growthStage) {
            case 1:
                return "Benih";
            case 2:
                return "Tunas";
            case 3:
                return "Tanaman Kecil";
            case 4:
                return "Tanaman Dewasa";
            case 5:
                return "Berbunga";
        }
        return "Unknown";
    }

    public void giveWater() {
        waterCount++;
        validateGrowth();
    }

    public void giveFertilizer() {
        fertilizerCount++;
        validateGrowth();
    }

    public void printStatus() {
        System.out.println(displayGrowthStatus() + " (Tahap " + getGrowthStage() + ")\n");
        if (growthStage > 4)
            System.out.println("Nama Tanaman    : " + getName() + "\n");
        System.out.println("Jumlah air      : " + waterCount);
        System.out.println("Jumlah pupuk    : " + fertilizerCount);
    }
}
