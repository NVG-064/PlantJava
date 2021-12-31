package lib.Plants;

import lib.Plant;

public class Azalea extends Plant {
    public Azalea() {
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
