package lib.Plants;

import lib.Plant;

public class Aster extends Plant {
    public Aster() {
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
