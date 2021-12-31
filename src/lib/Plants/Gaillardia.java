package lib.Plants;

import lib.Plant;

public class Gaillardia extends Plant {
    public Gaillardia() {
        super();
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
