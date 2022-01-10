package lib.Plants;

import lib.Plant;

public class Gaillardia extends Plant {
    public Gaillardia() {
        super();
        // 50 - 20 + 20, same as default
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 1 && fertilizerCount >= 2) {
            waterCount -= 1;
            fertilizerCount -= 2;
            growthStage++;
        }
    }
}
