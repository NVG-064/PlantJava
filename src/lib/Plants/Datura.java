package lib.Plants;

import lib.Plant;

public class Datura extends Plant {
    public Datura() {
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
