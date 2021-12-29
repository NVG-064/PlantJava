package lib;

public abstract class Plant {
    protected Integer growthStage;

    protected Integer waterCount;
    protected Integer fertilizerCount;

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
        return this.getClass().getSimpleName();
    }

    public String getGrowthStage() {
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

    public Integer getWaterCount() {
        return waterCount;
    }

    public Integer getFertilizerCount() {
        return fertilizerCount;
    }
}
