package lib.Plants;

import lib.Plant;

public class Hymenocallis extends Plant {
    public Hymenocallis() {
        super();
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 3 && fertilizerCount >= 1) {
            waterCount -= 3;
            fertilizerCount -= 1;
            growthStage++;
        }
    }
}
