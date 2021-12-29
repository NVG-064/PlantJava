package lib;

public abstract class Plant {
    protected String plantName;
    protected int growthStage;

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
        }
        return "Berbunga";
    }

    public boolean isMature() {
        return growthStage > 4;
    }

    public void giveWater() {
        waterCount++;
        validateGrowth();
    }

    public void giveFertilizer() {
        fertilizerCount++;
        validateGrowth();
    }

    public int getWaterCount() {
        return waterCount;
    }

    public int getFertilizerCount() {
        return fertilizerCount;
    }
}
