package lib.Plants;

import lib.Plant;

public class Rose extends Plant {
    public Rose() {
        super();
        point = 210;
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 5 && fertilizerCount >= 4) {
            waterCount -= 5;
            fertilizerCount -= 4;
            growthStage++;
        }
    }
}
