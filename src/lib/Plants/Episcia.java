package lib.Plants;

import lib.Plant;

public class Episcia extends Plant {
    public Episcia() {
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
