package lib.Plants;

import lib.Plant;

public class Sunflower extends Plant {
    public Sunflower() {
        super();
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 2 && fertilizerCount >= 1) {
            waterCount -= 2;
            fertilizerCount -= 1;
            growthStage++;
        }
    }
}
