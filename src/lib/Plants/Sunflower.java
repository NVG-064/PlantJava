package lib.Plants;

import lib.Plant;

public class Sunflower extends Plant {
    public Sunflower() {
        super();
        point = 45;
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
