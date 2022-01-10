package lib.Plants;

import lib.Plant;

public class Crocus extends Plant {
    public Crocus() {
        super();
        point = 70;
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 4 && fertilizerCount >= 1) {
            waterCount -= 4;
            fertilizerCount -= 1;
            growthStage++;
        }
    }
}
