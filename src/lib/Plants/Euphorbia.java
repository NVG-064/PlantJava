package lib.Plants;

import lib.Plant;

public class Euphorbia extends Plant {
    public Euphorbia() {
        super();
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 4 && fertilizerCount >= 3) {
            waterCount -= 4;
            fertilizerCount -= 3;
            growthStage++;
        }
    }
}
