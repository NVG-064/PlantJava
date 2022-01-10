package lib.Plants;

import lib.Plant;

public class Kimilsungia extends Plant {
    public Kimilsungia() {
        super();
        point = 110;
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 4 && fertilizerCount >= 2) {
            waterCount -= 4;
            fertilizerCount -= 2;
            growthStage++;
        }
    }
}
