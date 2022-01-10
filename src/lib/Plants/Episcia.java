package lib.Plants;

import lib.Plant;

public class Episcia extends Plant {
    public Episcia() {
        super();
        point = 150;
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
